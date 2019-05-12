import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-31 14:10
 **/
public class TwinsLockTest {

    @Test
    public void test(){
        final Lock lock = new TwinsLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();

                    //一次可以进来两个线程
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for(int i = 0;i < 10;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        //不太明白？？？
        for (int i = 0;i < 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("*******");
        }
    }
}
