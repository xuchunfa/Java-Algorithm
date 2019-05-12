import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: 实现共享式访问的锁
 * @author: Xu chunfa
 * @create: 2018-08-31 11:22
 **/
public class TwinsLock implements Lock {

    private final Syn syn = new Syn(5);

    private static final class Syn extends AbstractQueuedSynchronizer{

        public Syn(int status){
            if(status < 0){
                throw new IllegalArgumentException("status must > 0");
            }
            setState(status);
        }


        //共享式访问同步资源,返回值 >=0 时能获取同步状态
        @Override
        protected int tryAcquireShared(int reduceCount) {

            for(;;){//自旋

                int current = getState();

                int newCount = current - reduceCount;

                //返回值小于0说明不能获取同步状态
                if(newCount < 0 || compareAndSetState(current,newCount)){
                    return newCount;
                }
            }

        }

        @Override
        protected boolean tryReleaseShared(int increaseCount) {
            for(;;){//自旋

                int current = getState();

                int newCount = current + increaseCount;

                //返回值小于0说明不能获取同步状态
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        syn.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        syn.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


}
