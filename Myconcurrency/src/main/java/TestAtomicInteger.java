import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 原子类
 * @author: Xu chunfa
 * @create: 2019-04-04 16:23
 **/
public class TestAtomicInteger {

    AtomicInteger ai = new AtomicInteger(0);

    //valueOffset：变量在AtomicInteger中的偏移量，可简单理解为变量的内存地址
    public void increase(){
        ai.getAndIncrement();
    }

    @Test
    public void test(){
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0;i < 100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 10;j++){
                        increase();
                    }
                }
            });
            threads.add(thread);
        }

        for(Thread thread : threads){
            thread.start();
        }

        //main线程等待所有其他线程执行完毕
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(ai.get());

    }
}
