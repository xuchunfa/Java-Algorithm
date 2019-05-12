import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description: 一个线程打印奇数另一个线程打印偶数
 * @author: Xu chunfa
 * @create: 2019-04-01 08:46
 **/
public class ThreadCreation {

    static class PrintOddAndEven implements Runnable{
        private static final int NUMBERS = 20;
        private static volatile int index = 1;
        private int flag;
        static Object lock = new Object();//static

        public PrintOddAndEven(int flag) {
            this.flag = flag;
        }

        @Override
        public void run(){
            while(index < NUMBERS){
                synchronized (lock){
                    while ((index & 1) != flag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+": "+index);
                    index++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread oddThread = new Thread(new PrintOddAndEven(1),"oddThread");
        Thread evenThread = new Thread(new PrintOddAndEven(0),"evenThread");
        oddThread.start();
        evenThread.start();
    }

}
