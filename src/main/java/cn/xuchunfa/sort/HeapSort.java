package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 堆排序(选择排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:23
 **/
public class HeapSort {

    public static void heapSort(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        int len = a.length;
        //构建大顶堆
        for(int i = len/2-1;i>=0;i--){
            createHeap(a,i,len);
        }

        for(int j = a.length-1;j>0;j--){
            swap(a,0,j);
            createHeap(a,0,j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void createHeap(int[] a,int i,int len) {

        int father = a[i];
        int j;//j代表子结点坐标 i代表父结点坐标

        while(2*i + 1 < len){

            j = 2*i + 1;

            if(j + 1 < len && a[j] < a[j+1] )
                j++;

            if(a[j] > father){
                a[i] = a[j];
                i = j;
            }else {
                break;
            }
        }

        //找到最终位置
        a[i] = father;
    }

    public static void main(String[] args){
        int[] a = {1,1,1};
        HeapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
