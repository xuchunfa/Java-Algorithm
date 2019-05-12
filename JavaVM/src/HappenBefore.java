/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-29 11:33
 **/
public class HappenBefore {

    private int a = 0;
    private boolean ready = false;

    public void getA() {
        if(true){
            System.out.println("a = " + a);
        }
    }

    public void setA() {
        ready = true;
        a = 1;
    }

    private class GetAndSetRunnable implements Runnable{

        boolean flag;

        public GetAndSetRunnable(boolean flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            if(flag){
                setA();
            }else {
                getA();
            }
        }
    }

    public static void main(String[] args){
        HappenBefore obj = new HappenBefore();

        Thread thread1 = new Thread(obj.new GetAndSetRunnable(true));
        Thread thread2 = new Thread(obj.new GetAndSetRunnable(false));
        thread1.start();
        thread2.start();
    }
}
