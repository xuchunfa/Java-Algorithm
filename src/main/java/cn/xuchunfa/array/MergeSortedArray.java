package cn.xuchunfa.array;

import java.util.Arrays;

/**
 * @description: 合并两个有序数组(默认升序)
 * @author: Xu chunfa
 * @create: 2018-07-20 17:05
 **/
public class MergeSortedArray {

    //时间复杂度(O(n)) 空间复杂度(O(n))
    public static int[] merge(int[] a,int[] b){

        if(a==null || b==null){
            System.out.println("输入两个数组");
        }

        if(a.length == 0)
            return b;

        if(b.length == 0)
            return a;

        int len1 = a.length;
        int len2 = b.length;

        int[] c = new int[len1+len2];
        int i = len1 - 1;
        int j = len2 - 1;

        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                c[i+j+1] = a[i];
                i--;
            }else{
                c[i+j+1] = b[j];
                j--;
            }
        }

        while (i >= 0){
            c[i+j+1] = a[i];
            i--;
        }

        while(j >= 0){
            c[i+j+1] = b[j];
            j--;
        }

        return c;
    }


    //时间复杂度(O(n)) 空间复杂度(O(1)) 直接在第一个数组上操作
    public static void merge1(int[] a,int[] b){

        if(a==null || b==null){
            System.out.println("输入两个数组");
        }

        int len1 = a.length;
        int len2 = b.length;

        int i = len1 - len2 -1;
        int j = len2 - 1;

        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                a[i+j+1] = a[i];
                i--;
            }else{
                a[i+j+1] = b[j];
                j--;
            }
        }

        while(j >= 0){
            a[i+j+1] = b[j];
            j--;
        }

    }

    public static void main(String[] args){

        int[] a ={1,1,1};
        int[] b = {1,1,1,1};
        int[] c = new int[a.length+b.length];

        c = MergeSortedArray.merge(a,b);

        //打印数组元素
        System.out.println(Arrays.toString(c));
    }

}
