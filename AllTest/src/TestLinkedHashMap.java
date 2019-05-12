import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-25 19:19
 **/
public class TestLinkedHashMap {

    public static void main(String[] args){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>(10, 0.75f,true);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.get("2");
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next().getKey());
        }

    }
}
