import java.util.Arrays;
import java.util.Vector;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-23 16:47
 **/
public class TestVector {

    public static void main(String[] args) throws InterruptedException {
        final Vector<Integer> vector = new Vector<Integer>();
        for(int i = 0;i < 5;i++){
            vector.add(i);
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (vector) {
                   for(Integer integer : vector){
                       System.out.print(integer + " ");
                   }
                   System.out.println();
                }
            }
        });

        //Thread.sleep(1000);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                vector.remove(1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(Arrays.toString(vector.toArray()));
    }
}
