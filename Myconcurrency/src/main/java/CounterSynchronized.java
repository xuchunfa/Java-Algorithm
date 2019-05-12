/**
 * @description: synchronized实现 count++
 * @author: Xu chunfa
 * @create: 2018-09-01 12:19
 **/
public class CounterSynchronized {

    private int counter = 0;

    public synchronized void count(){
        counter++;
    }

    public static void main(String[] args){

        final CounterSynchronized test = new CounterSynchronized();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                test.count();
            }
        };

        for(int i = 0;i < 10;i++){
            Thread thread = new Thread(r);
            thread.start();

            //让main线程休息1s 来帮助其他线程获得运行的机会
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(test.counter);
        }
    }

}
