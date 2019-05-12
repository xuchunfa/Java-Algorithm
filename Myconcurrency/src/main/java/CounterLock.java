/**
 * @description: 锁的简单模拟
 * @author: Xu chunfa
 * @create: 2018-09-01 10:52
 **/


public class CounterLock {

    MyLock lock = new MyLock();
    //private MyLock lock;
    private int counter = 0;

   /* public CounterLock(MyLock lock){
        this.lock = lock;
    }*/

    static final class MyLock{

        private boolean isLocked = false;

        //等待通知机制
        public synchronized void lock() throws InterruptedException {
            while (isLocked){
                wait();
            }
            isLocked = true;
        }

        public synchronized void unlock(){
            isLocked = false;
            notify();
        }
    }


    public void count() throws InterruptedException {
        lock.lock();
        try {
            counter++;
            Thread.sleep(1000);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        //MyLock lock = new MyLock();
        final CounterLock cl = new CounterLock();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    cl.count();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for(int i = 0;i < 10;i++){
            Thread thread = new Thread(r);
            thread.start();
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(cl.counter);
        }


    }

}
