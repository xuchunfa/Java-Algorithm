import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: wait/notify
 * @author: Xu chunfa
 * @create: 2019-04-04 20:40
 **/
public class TestProducerConsumer {

    private static final int cap = 3;
    static Queue<Integer>  queue = new LinkedList<Integer>();
    static Object lock = new Object();

    static class Producer implements Runnable{
        private static int product;
        @Override
        public void run() {
            synchronized (lock){
                while (queue.size() == cap){
                    try {
                        System.out.println("queue is full: "+Thread.currentThread().getName()+" is waitting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" is product: "+product);
                queue.offer(product++);
                lock.notify();
            }
        }
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (queue.size() == 0){
                    try {
                        lock.wait();
                        System.out.println("queue is empty: "+Thread.currentThread().getName()+" is waitting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int product = queue.poll();
                System.out.println(Thread.currentThread().getName()+" is consume: "+product);
                lock.notify();
            }
        }
    }


    @Test
    public void test(){
        
        //for(int i = 0;i < 3;i++){
        //    new Thread(new Producer(),"Producer"+i).start();
        //}
        Thread t1 = new Thread(new Producer(),"Producer1");
        Thread t2 = new Thread(new Producer(),"Producer2");
        Thread t3 = new Thread(new Producer(),"Producer3");
        Thread t4 = new Thread(new Producer(),"Producer3");

        Thread thread = new Thread(new Consumer(),"Consumer");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        thread.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("queue size = "+queue.size());
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            Integer e = iterator.next();
            System.out.println(e);
        }
    }
}
