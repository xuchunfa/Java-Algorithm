import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: 模拟所有人到达后开始旅行的问题
 * @author: Xu chunfa
 * @create: 2019-04-15 21:21
 **/
public class TestCyclicBarrier {
    
    public static void main(String[] args){
        CyclicBarrier barrier = new CyclicBarrier(3,new TouristGuide());
        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new Tourist("tom",barrier));
        executor.execute(new Tourist("curry",barrier));
        executor.execute(new Tourist("jerry",barrier));
    }

    private static class TouristGuide implements Runnable{

        @Override
        public void run() {
            System.out.println("导游开始发放护照");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Tourist implements Runnable {
        private String name;
        private CyclicBarrier barrier;
        public Tourist(String name,CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "已到达集合地点");
            try {
                barrier.await();
                System.out.println(name + "开始旅行啦");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
