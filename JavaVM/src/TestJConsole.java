import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-28 09:52
 **/
public class TestJConsole {

    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];

    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0;i < num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }

}
