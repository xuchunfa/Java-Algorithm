package cn.xuchunfa.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.jar.JarEntry;

/**
 * @description: 随机化版本的快排(交换排序)
 * @author: Xu chunfa
 * @create: 2018-07-27 22:45
 **/
public class QuickSort {

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

        //轴值在[start,end]区间内随机生成,然后把轴值交换到数组中第一位
        rand_pivot(a,start,end);

        int i = start;
        int j = end;
        int pivot = a[start];

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

    public static int versePartition(int[] a,int start,int end){
        int i = start;
        int j = end;
        int pivot = a[start];
        while (i < j){
            while (i < j && a[j] <= pivot){
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] >= pivot){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }


    //随机化的选择主元
    private static void rand_pivot(int[] a, int start, int end) {
        Random random = new Random();
        int rand = start + random.nextInt(end - start + 1);//随机函数生成的整数区间在[0,length)

        //交换第一个数和随机选出来的数
        int temp = a[start];
        a[start] = a[rand];
        a[rand] = temp;
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
