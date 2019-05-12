package cn.xuchunfa.classic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @description:
 *
 * 输入：[1,2,4] sum=4
 *
 * 输出：[1,1,1,1]
 *      [1,1,2]
 *      [2,2]
 *
 * @author: Xu chunfa
 * @create: 2019-04-06 21:25
 **/
public class CombineSum {

    private ArrayList<Integer> combine = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> allCombine = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findCombination(int[] array,int sum,int i){
        if(sum < 0){
            return allCombine;
        }

        if(sum == 0){
            allCombine.add(new ArrayList<>(combine));
            return allCombine;
        }

        while(i < array.length && sum - array[i] >= 0){
            combine.add(array[i]);
            findCombination(array,sum-array[i],i);
            i++;
            combine.remove(combine.size()-1);
        }
        return allCombine;
    }

    @Test
    public void test(){
        int[] a = {1,4,2,6};
        Arrays.sort(a);
        System.out.println(findCombination(a,4,0).toString());
    }
}
