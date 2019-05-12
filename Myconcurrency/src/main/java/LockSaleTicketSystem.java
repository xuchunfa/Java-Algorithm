import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 锁实现买票系统
 * @author: Xu chunfa
 * @create: 2018-09-01 15:19
 **/
public class LockSaleTicketSystem {
    
    static class SellTicket implements Runnable {

        // 定义票
        private int tickets = 10;

        // 定义锁对象
        private Lock lock = new ReentrantLock();

        @Override
        public void run() {
            while (true) {
                try {
                    // 加锁
                    lock.lock();
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + "正在出售第" + (tickets--) + "张票");
                    }
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        }
    }
    
    public static void main(String[] args){

        SellTicket str = new SellTicket();

        Thread tr1 = new Thread(str, "窗口1");
        Thread tr2 = new Thread(str, "窗口2");
        Thread tr3 = new Thread(str, "窗口3");

        tr1.start();
        tr2.start();
        tr3.start();

        //try {
        //    tr1.join();
        //    tr2.join();
        //    tr3.join();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

    }
}
