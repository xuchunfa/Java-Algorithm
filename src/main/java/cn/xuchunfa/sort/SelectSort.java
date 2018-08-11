package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 简单选择排序(选择排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:22
 **/
public class SelectSort {

    public static void selectSort(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        for(int i = 0;i<a.length-1;i++){

            for(int j = i+1;j<a.length;j++)
            {
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {6,3,5,1,9,12,2,8,8,-1};
        BubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

}
