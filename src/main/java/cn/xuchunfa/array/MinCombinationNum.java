package cn.xuchunfa.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 用正整数数组中的元素组合出一个最小的数
 * @author: Xu chunfa
 * @create: 2019-04-17 16:35
 **/
public class MinCombinationNum {

    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);//结果大于0,o1大于o2,将o1放到o2后面
            }
        });

        for(Integer num : list){
            sb.append(num);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        int[] a = {3,34,341,45};
        System.out.println(PrintMinNumber(a));
    }
}
