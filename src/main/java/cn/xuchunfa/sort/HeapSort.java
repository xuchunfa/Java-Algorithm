package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 堆排序(选择排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:23
 **/

/*
 *  时间复杂度：(不依赖数据分布)
 *    最好：O(nlogn)
 *    最坏：O(nlogn)
 *    平均：O(nlogn)
 *  空间复杂度：
 *    O(1)
 *  稳定性：
 *    不稳定
 * */
public class HeapSort {

    public static void heapSort(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        int len = a.length;
        //构建大顶堆
        for(int i = len/2-1;i>=0;i--){
            createHeap(a,i,len);
            //createMinHeap(a,i,len);
        }

        for(int j = a.length-1;j>0;j--){
            swap(a,0,j);//a[0]代表最大的结点 a[j]代表最后一个结点

            //从堆顶开始向下调整,已经取出了最大的堆结点
            createHeap(a,0,j);
            //createMinHeap(a,0,j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //构建大顶堆的方法
    public static void createHeap(int[] a,int i,int len) {

        int father = a[i];
        int j = 2*i + 1;//j代表子结点坐标 i代表父结点坐标

        while(j < len){//如果i结点在堆顶上的话,需要自顶向下调整

            j = 2*i + 1;

            if(j + 1 < len && a[j] < a[j+1] )
                j++;

            if(a[j] > father){
                a[i] = a[j];
                i = j;
            }else {//不用调整的话就不用再向下循环了,子节点都已经调整好了
                break;
            }
            j = 2*i+1;
        }

        //找到最终位置
        a[i] = father;
    }

    //构建小顶堆
    public static void createMinHeap(int[] a,int i,int length){
        int father = a[i];
        int j = 2*i + 1;
        while (j < length){
            if(j+1 < length && a[j] > a[j+1]){
                j++;
            }
            if(a[j] < father){
                a[i] = a[j];
                i = j;
            }else {
                break;
            }
            j = 2*i+1;
        }
        a[i] = father;
    }

    public static void main(String[] args){
        int[] a = {6,8,2,10,12,1};
        HeapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
