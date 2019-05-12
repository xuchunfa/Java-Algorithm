package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: Xu chunfa
 * @create: 2018-07-28 19:24
 **/

/*
 *  时间复杂度：(不依赖数据分布)
 *    最好：O(nlogn)
 *    最坏：O(nlogn)
 *    平均：O(nlogn)
 *  空间复杂度：
 *    O(n)
 *  稳定性：
 *    稳定
 * */
public class MergeSort {

    //临时数组
    public static void sort(int[] a){
        int[] temp = new int[a.length];
        mergeSort(a,0,a.length-1,temp);
    }

    //治的思想
    public static void merge(int[] a,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }

        while (i <= mid){
            temp[k++] = a[i++];
        }

        while (j <= right){
            temp[k++] = a[j++];
        }

        k = 0;
        while (left <= right){
            a[left++] = temp[k++];
        }
    }

    //归并排序
    public static void mergeSort(int[] a,int left,int right,int[] temp){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        if(left < 0 || left >= a.length || right < 0 || right >= a.length ){
            throw new RuntimeException("越界");
        }

        if(left < right){
            int mid = (left + right)/2;
            mergeSort(a,left,mid,temp);
            mergeSort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }

    public static void main(String[] args){
        int[] a = {6,5,4,4,4,3,2,1};
        //sort(a);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
