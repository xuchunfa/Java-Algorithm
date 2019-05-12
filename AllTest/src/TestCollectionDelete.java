import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 删除集合元素
 * @author: Xu chunfa
 * @create: 2019-04-17 10:03
 **/
public class TestCollectionDelete {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("a");
        for(int i = 0;i < list.size();i++){
            if(list.get(i).equals("a")){
                list.remove(list.get(i));
            }
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("a")) {
                iterator.remove();
            }
        }

        //for(String s : list){
        //    if(s.equals("a")){
        //        list.remove(s);
        //    }
        //}

        System.out.println(list);
    }
}
