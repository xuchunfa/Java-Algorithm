package cn.xuchunfa.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 连续正数子序列
 * @author: Xu chunfa
 * @create: 2019-05-01 14:01
 **/
public class ContinuousPositiveSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1,high = 2;
        int curSum;
        while (low < high){
            curSum = (high - low + 1)*(low + high)/2;
            if(curSum == sum){
                ArrayList<Integer> seq = new ArrayList<>();
                for(int i = low;i <= high;i++){
                    seq.add(i);
                }
                result.add(seq);
                low++;
            }else if(curSum < sum){
                high++;
            }else {
                low++;
            }
        }
        return result;
    }

    @Test
    public void test(){
        //System.out.println(FindContinuousSequence(15).toString());
        String str = "lloveyoumuch.";
        String[] strs = str.split(" ");
        System.out.println(Arrays.toString(strs));

    }
}
