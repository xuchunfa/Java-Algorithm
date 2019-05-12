/**
 * @description: 买票系统
 * @author: Xu chunfa
 * @create: 2018-08-29 14:34
 **/
public class SaleTicketSystem {

    private static final int THREAD_COUNT = 10;

    //10个窗口卖三张票
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        TicketWindow window = new TicketWindow();

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(window,"售票窗口"+i);
            threads[i].start();
        }
    }


    static class TicketWindow implements Runnable {

        private int tickets = 30;

        @Override
        public void run() {
            while (true) {
                synchronized (this){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "准备出票,还剩余票:" + tickets + "张");
                        tickets--;
                        System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张");

                        try {
                            //睡眠时释放对象锁
                            wait();
                            //Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("余票不足,暂停出售!");

                        try {
                            //在未来5分钟内不参与CPU竞争
                            //Thread.Sleep(0)代表触发操作系统重新进行一次CPU竞争
                            //睡眠时持有对象锁
                            Thread.sleep(1000 * 60 * 5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    }
