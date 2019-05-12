/**
 * @description: 可重入锁的简单理解
 * @author: Xu chunfa
 * @create: 2018-09-01 14:56
 **/
public class MyReentrantLock {

    boolean isLocked = false;

    Thread lockedThread = null;

    private int lockedCount = 0;


    public synchronized void lock() throws InterruptedException {
        Thread callThread = Thread.currentThread();
        while (isLocked && callThread != lockedThread){
            wait();
        }
        isLocked = true;
        lockedThread = callThread;
        lockedCount++;
    }

    public synchronized void unlock(){

        if(Thread.currentThread() == this.lockedThread){
            lockedCount--;
        }

        if(lockedCount == 0) {
            isLocked = false;
            notify();
        }
    }
}
