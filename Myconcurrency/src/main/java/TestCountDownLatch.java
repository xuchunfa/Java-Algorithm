import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-15 16:47
 **/
public class TestCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args){
        Executor executor = Executors.newFixedThreadPool(5);
        for(int i = 0;i < 5;i++){
            executor.execute(new MyWorker(latch,i));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all threads has executed tasks");
    }

    private static class MyWorker implements Runnable {
        private CountDownLatch cdl;
        private int i;
        public MyWorker(CountDownLatch latch, int i) {
            this.cdl = latch;
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is execute task "+i);
            cdl.countDown();
        }
    }
}
