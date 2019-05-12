/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-29 15:54
 **/
public class SleepAndWait {


    static class ThreadTest implements Runnable {
        int number = 10;

        public void firstMethod() throws Exception {
            synchronized (this) {
                number += 100;
                System.out.println(number);
            }
        }

        public void secondMethod() throws Exception {
            synchronized (this) {
                /**
                 * (休息2S,阻塞线程)
                 * 以验证当前线程对象的机锁被占用时,
                 * 是否被可以访问其他同步代码块
                 */
                //返回结果2100
                Thread.sleep(2000);

                //System.out.println("hello");
                //返回结果110
                //wait(2000);
                number *= 200;
            }
        }

        @Override
        public void run() {
            try {
                firstMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        ThreadTest thread = new ThreadTest();
        Thread myThread = new Thread(thread);
        myThread.start();

        //这句话的意思是让主线程睡眠1s,此时先运行myThread线程
        //Thread.sleep(1000);

        thread.secondMethod();//先于myThread.start()执行下,即先运行主线程

        //对于wait(2000)情况,number=22000？？？
        System.out.println("number="+thread.number);
    }
        
        
}
