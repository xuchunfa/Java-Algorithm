import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-01 11:14
 **/
public class ThreadPoolDemo {

    static class MyTask implements Runnable{

        private int i;

        public MyTask(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is execute task-"+i);
        }
    }

    public static void main(String[] args){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,4,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),new ThreadPoolExecutor.DiscardOldestPolicy());
        for(int i = 0;i < 20;i++){
            pool.execute(new MyTask(i));
            Iterator iterator = pool.getQueue().iterator();
            System.out.println("任务列表：");
            while (iterator.hasNext()){
                MyTask task = (MyTask) iterator.next();
                System.out.println("任务："+task.i);
            }
        }
    }
}
