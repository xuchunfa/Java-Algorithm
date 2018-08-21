package cn.xuchunfa.sort;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @description: 快排(交换排序)
 * @author: Xu chunfa
 * @create: 2018-07-27 22:45
 **/
public class QuickSort {

    //时间复杂度:O(n2) 不算快排
    public static void quickSort1(int[] array){
        int i = 0;
        int j;
        int length = array.length;

        if(array == null){
            throw new RuntimeException("输入数组");
        }

        if(length <= 1){
            return;
        }

        while(i < length){
            j = i + 1;
            while (j<length){
                if(array[j] <= array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                j++;
            }
        i++;
    }
    }

    public static void swap(int[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partition(int[] a,int start,int end){

        if(a == null || start < 0 || end > a.length-1){
            throw new RuntimeException("参数不合法");
        }


        int pivot = a[start];
        int i = start;
        int j = end;
        while (i < j){
            while (i < j && a[j] >= pivot){
                j--;
            }

            //a[i] = a[j];//这种写法时条件不能为a[j] > pivot必须要 >=
            swap(a,i,j);

            while (i < j && a[i] <= pivot){
                i++;
            }

            //a[j] = a[i];
            swap(a,j,i);
        }

        //a[i] 或者 a[j]
        //a[i] = pivot;

        return i;
    }

    public static void quickSort(int[] a,int start,int end){

        if(start >= end)
            return;

        int index = partition(a,start,end);
        quickSort(a,start,index-1);
        quickSort(a,index+1,end);

        /*int index;
        if(start < end){
            index = partition(a,start,end);
            quickSort(a,start,index-1);
            quickSort(a,index+1,end);
        }*/
    }

    public static void main(String[] args){
        int[] a = {2,4,5,1,1,2,7,6,3};
        QuickSort.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
