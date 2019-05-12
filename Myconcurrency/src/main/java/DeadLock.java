/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-28 10:36
 **/
public class DeadLock {
    static class SynAddRunnable implements Runnable{
        private int a,b;

        public SynAddRunnable(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }
}
