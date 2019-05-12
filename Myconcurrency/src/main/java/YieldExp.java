/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-29 20:34
 **/
public class YieldExp {

    //非静态内部类中不能存在静态成员
    class Hello{
        private int a;//private static int a 错误
    }


    //在静态内部类中可以存在静态成员
    static class YieldThread extends Thread{
        private String name;

        public YieldThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                System.out.println("" + this.getName() + "-----" + i);
                //当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
                if (i == 30) {
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args){

        //静态内部类 可以直接创建实例不需要依赖于外围类
        Thread thread1 = new YieldThread("thread-1");

        //非静态内部类可以按以下方式访问
        //YieldExp.YieldThread thread3 = new YieldExp().new YieldThread();
        Thread thread2 = new YieldThread("thread-2");

        thread1.start();
        thread2.start();
    }
}
