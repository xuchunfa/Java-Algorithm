package cn.xuchunfa.array;

import java.util.*;

/**
 * @description: 找到数组中重复的数,数组长度为 n,数组元素为 0~n-1(时间复杂度:O(n),空间复杂度:O(n))
 * @author: Xu chunfa
 * @create: 2018-07-18 11:57
 **/
public class Duplication {

    private static Set<Integer> list;

    public static void findDup(int[] a){

        Set<Integer> list = new HashSet<Integer>();

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0;i<a.length;i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], i);
            } else {
                list.add(a[i]);
            }
        }

        if(list.size() == 0){
            System.out.println("没有重复的数字");
            System.exit(0);
        }

        System.out.println("重复的数字：");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,6,6,6};

        Duplication.findDup(a);

    }


}
