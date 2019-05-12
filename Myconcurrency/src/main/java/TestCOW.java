import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-23 16:11
 **/
public class TestCOW {
    private static volatile int index;//保证index可见

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        list.add("xu");
        list.add("dai");
        //final Iterator<String> iterator = list.iterator();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        //读线程
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for(String str : list){
                        System.out.print(str + " ");
                    }
                    System.out.println();
                }
            });

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("hello"+index++);
                }
            });
        }

        //写线程
        //for(int i = 0;i < 3;i++){
        //    executor.execute(new Runnable() {
        //        @Override
        //        public void run() {
        //            list.add("hello"+index++);
        //        }
        //    });
        //}

        Thread.sleep(1000);
        executor.shutdown();
        System.out.println(Arrays.toString(list.toArray()));

    }
}
