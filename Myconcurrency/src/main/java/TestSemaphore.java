import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-16 09:07
 **/
public class TestSemaphore {
    public static void main(String[] args){
        Executor executor = Executors.newFixedThreadPool(10);
        final Semaphore semaphore = new Semaphore(5);
        for(int i = 0; i < 10;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " acquire limited resource to exe task");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
