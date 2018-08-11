package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 希尔排序(插入排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:21
 **/
public class ShellSort {

    public static void shellSort(int[] a){
        for(int increment = a.length/2;increment > 0 ;increment /= 2){
            for(int i = increment;i<a.length;i++){
                int j = i;
                while (j - increment >=0  && a[j-increment] > a[j]){
                    //交换排序
                    swap(a,j,j-increment);
                    j -= increment;
            }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shellSort1(int[] a){
        for(int increment = a.length/2;increment > 0 ;increment /= 2){
            for(int i = increment;i<a.length;i++){
                int j = i;
                int temp = a[j];

                //直接插入
                while(j-increment >= 0 && a[j-increment] > temp){
                    a[j] = a[j-increment];
                    j -= increment;
                }
                a[j] = temp;
            }
        }
    }
    
    public static void main(String[] args){
        int[] a = {9,8,7,6,5,4,3,2,1};
        ShellSort.shellSort1(a);
        System.out.println(Arrays.toString(a));
    }
}
