import java.util.HashMap;
import java.util.Map;

/**
 * @description: 读写锁的一种 synchronized实现方法
 * @author: Xu chunfa
 * @create: 2018-09-02 10:49
 **/
public class ReadWriteLock {

    private Map<Thread, Integer> readingThreads =
            new HashMap<Thread, Integer>();

    private int writeAccesses    = 0;
    private int writeRequests    = 0;
    private Thread writingThread = null;

    public synchronized void lockRead()
            throws InterruptedException{
        Thread callingThread = Thread.currentThread();

        //能够获取读锁的条件：
        //当前线程是写线程、没有写线程、是读线程、此时没有写请求
        while(! canGrantReadAccess(callingThread)){
            wait();
        }

        readingThreads.put(callingThread,
                (getReadAccessCount(callingThread) + 1));
    }

    private boolean canGrantReadAccess(Thread callingThread){
        if(isWriter(callingThread)) return true;// 此语句是为了让“写锁”能拥有“读锁”

        /*
         * 原则1：此重入锁需要保证写线程优先于读线程
         * 第一步，判断是否已有“写锁”（指有线程已经拥有写锁了），有则不能分配读的权限，没有则往下走
         * 第二步，判断是否当前线程是否已经持有“读锁”，如果没有则继续往下走
         * 第三步，判断是否有写请求，如果有则不能分配，因为要保证原则1
         */
        if(hasWriter()) return false;
        if(isReader(callingThread)) return true;
        if(hasWriteRequests()) return false;
        return true;
    }


    public synchronized void unlockRead(){
        Thread callingThread = Thread.currentThread();
        if(!isReader(callingThread)){
            throw new IllegalMonitorStateException(
                    "Calling Thread does not" +
                            " hold a read lock on this ReadWriteLock");
        }
        int accessCount = getReadAccessCount(callingThread);
        if(accessCount == 1){
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, (accessCount -1));
        }
        notifyAll();
    }

    public synchronized void lockWrite()
            throws InterruptedException{
        writeRequests++;
        Thread callingThread = Thread.currentThread();

        //能够获取写锁的条件：

        while(!canGrantWriteAccess(callingThread)){
            wait();
        }
        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException{
        if(!isWriter(Thread.currentThread())){
            throw new IllegalMonitorStateException(
                    "Calling Thread does not" +
                            " hold the write lock on this ReadWriteLock");
        }
        writeAccesses--;
        if(writeAccesses == 0){
            writingThread = null;
        }
        notifyAll();
    }

    //当前线程是写线程、没有读线程、此时没有写线程、此时没有其他线程在写
    private boolean canGrantWriteAccess(Thread callingThread){

        if(isOnlyReader(callingThread)) return true;// 为了已经获得“读锁”的线程能拥有写锁
        /*
         * 第一步，当前有读锁，则不能分配，否则，往下走
         * 第二步，再判断当前是否有写锁，writing==null则表示没有写锁，可以分配，writingThread != null 则表示有写锁，往下走
         * 第三步，判断当前线程就是持锁线程（writingThread）如果是，!isWriter(callingThread)返回false，最终表示可以分配写锁（重入）
         * 如果不是持锁线程，则!isWriter(callingThread)返回true，最终表示别的线程拥有写锁，不能再分配写锁
         *
         */
        if(hasReaders()) return false;
        if(writingThread == null) return true;
        if(!isWriter(callingThread)) return false;
        return true;
    }


    private int getReadAccessCount(Thread callingThread){
        Integer accessCount = readingThreads.get(callingThread);
        if(accessCount == null) return 0;
        return accessCount.intValue();
    }


    private boolean hasReaders(){
        return readingThreads.size() > 0;
    }

    private boolean isReader(Thread callingThread){
        return readingThreads.get(callingThread) != null;
    }

    private boolean isOnlyReader(Thread callingThread){
        return readingThreads.size() == 1 &&
                readingThreads.get(callingThread) != null;
    }

    private boolean hasWriter(){
        return writingThread != null;
    }

    private boolean isWriter(Thread callingThread){
        return writingThread == callingThread;
    }

    private boolean hasWriteRequests(){
        return this.writeRequests > 0;
    }
}
