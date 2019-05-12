package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 简单选择排序(选择排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:22
 **/

/*
 *  时间复杂度：
 *    最好：O(n2)
 *    最坏：O(n2)
 *  空间复杂度：
 *    O(1)
 *  稳定性：
 *    不稳定
 * */
public class SelectSort {

    public static void selectSort(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        for(int i = 0;i<a.length-1;i++){

            for(int j = i+1;j<a.length;j++)
            {
                if(a[i] > a[j]){//减少空间复杂度
                    a[j] = a[i] + a[j];
                    a[i] = a[j] - a[i];
                    a[j] = a[j] - a[i];
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {6,3,5,1,9,12,2,8,8,-1};
        SelectSort.selectSort(a);
        System.out.println(Arrays.toString(a));
    }

}
