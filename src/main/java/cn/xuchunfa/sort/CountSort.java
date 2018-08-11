package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 计数排序(其中 k >= max(a)): k 要大于数组中的最大数
 * @author: Xu chunfa
 * @create: 2018-08-03 21:01
 **/
public class CountSort {

    //数组数字在0 ~ k之间
    public static int[] countSort(int[] a,int k){

        int[] elementCounter = new int[k+1];

        for(int i = 0;i<a.length;i++){
            elementCounter[a[i]]++;
        }

        //构造计数数组(即小于等于该元素的个数)
        int preSum = elementCounter[0];
        for(int j = 1;j<elementCounter.length;j++){
            elementCounter[j] = preSum + elementCounter[j];
            preSum = elementCounter[j];
        }


        int[] result = new int[a.length];

        //从原数组末尾开始遍历
        for(int i = a.length-1;i>=0;i--){
            result[elementCounter[a[i]]-1] = a[i];
            elementCounter[a[i]]--;
        }

        return result;
    }
    
    public static void main(String[] args){
        int[] a = {6,5,4,3,2,1};
        int[] result = new int[a.length];
        result = CountSort.countSort(a,6);
        System.out.println(Arrays.toString(result));
    }
}
