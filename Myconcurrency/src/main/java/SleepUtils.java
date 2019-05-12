import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-09-01 15:36
 **/
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
