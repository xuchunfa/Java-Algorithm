/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-28 15:10
 **/
public class UnsafeVolatile {

    public static volatile int pace = 0;

    public static void increase(){
        pace++;
    }

    public static final int COUNT = 10;

    public static void main(String[] args){
        Thread[] threads = new Thread[COUNT];

        for(int i = 0;i < COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 50;j++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        /*while (Thread.activeCount() > 1)
            Thread.yield();*/

        //按我们所设想的话应该返回500 实际要小于500
        System.out.println(pace);
    }
}
