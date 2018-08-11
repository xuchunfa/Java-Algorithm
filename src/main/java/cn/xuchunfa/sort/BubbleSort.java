package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序（交换排序）
 * @author: Xu chunfa
 * @create: 2018-07-28 19:24
 **/
public class BubbleSort {

    public static void bubbleSort(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }


        boolean swapFlag;
        //冒泡次数
        for(int i = 1;i<a.length;i++){

            //优化 a = {5,1,2,3,4}
            swapFlag = false;
            for(int j = 0;j<a.length-i;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapFlag = true;
                }
            }

            if (!swapFlag)
                break;
        }
    }

    public static void main(String[] args){
        int[] a = {6,3,5,1,9,12,2,8,8,-1};
        BubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

}
