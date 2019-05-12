import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-05 15:23
 **/
public class TestTreeMap {

    @Test
    public void test(){
        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("abc","hello");
        treeMap.put("abd","hello1");
        treeMap.put("abe","hello2");
        treeMap.put("aba","hello3");

        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> map = iterator.next();
            System.out.println("key="+map.getKey()+" value="+map.getValue());
        }
    }
}
