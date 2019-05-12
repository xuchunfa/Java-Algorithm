import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-04 17:02
 **/
public class TestEndThread {

    @Test
    public void test(){
        Thread thread = new Thread(new Runnable() {
            private volatile Boolean isRunning = true;
            @Override
            public void run() {
                int i = 0;
                while (isRunning && !Thread.currentThread().isInterrupted()){
                    i++;
                }
                System.out.println("Counter i = "+i);
            }

            public void end(){
                isRunning = false;
            }
        },"counter-thread");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结束线程
        thread.interrupt();

        //实现Runnable接口类EndThread
        //EndThread end = new EndThread;
        //end.end();

    }


}
