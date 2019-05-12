/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-17 20:04
 **/
public class MyThread {

    private static final int counter = 1000000;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
    }

    public static void concurrency() throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(int i = 0 ;i < counter;i++){
                    a += 2;
                }
                System.out.println("a = "+a);
            }
        });

        thread.start();

        int b = 0;
        for(int j = 0;j<counter;j++){
            b--;
        }

        long end = System.currentTimeMillis();

        long time = end - start;

        thread.join();
        System.out.println("concurrency:"+ time +"ms,b="+b);
    }
}
