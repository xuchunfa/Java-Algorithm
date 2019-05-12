package cn.xuchunfa.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Queue;

/**
 * @description: 未经过优化的快排
 * @author: Xu chunfa
 * @create: 2019-03-24 19:37
 **/

/*
 *  时间复杂度：
 *    最好：O(nlogn)
 *    最坏：O(n^2)
 *    平均：O(nlogn)
 *  空间复杂度：
 *    O(logn)
 *  稳定性：
 *    不稳定
 * */
public class NormalQuickSort {

    public int partion(int[] a,int start,int end){
        int pivot = a[start];
        int i = start;
        int j = end;
        while (i < j){
            while (i < j && a[j] >= pivot){
                j--;
            }
            a[i] = a[j];

            while (i < j && a[i] <= pivot){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public void sort(int[] a,int start,int end){
        if(start < end){
            int partition = partion(a,start,end);
            sort(a,start,partition-1);
            sort(a,partition+1,end);
        }
    }

    @Test
    public void test(){
        int[] a = {6,4,3,3,1,2,9,5};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
