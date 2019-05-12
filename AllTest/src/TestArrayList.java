import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-06 11:37
 **/
public class TestArrayList {

    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> all = new ArrayList<>();
    @Test
    public void test(){
        list1.add(1);
        //all.add(list1);
        all.add(new ArrayList<>(list1));
        System.out.println(all.toString());
        list1.add(2);
        System.out.println(all.toString());
        System.out.println(list1.toString());
    }
}
