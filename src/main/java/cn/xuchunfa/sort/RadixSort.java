package cn.xuchunfa.sort;

import java.util.Arrays;

/**
 * @description: 基数排序
 * @author: Xu chunfa
 * @create: 2018-07-28 19:25
 **/

/*
 *  时间复杂度：(k代表最高位数,例如100最高位为3)
 *    最好：O(nk)
 *    最坏：O(nk)
 *    平均：O(nk)
 *  空间复杂度：
 *    O(1)
 *  稳定性：
 *    稳定
 * */
public class RadixSort {

    public static void radixSort(int[] a,int k){
        int[] counter = new int[10];
        int[][] container = new int[10][a.length];
        int n = 1;
        int t = 0;
        while (n < k){
            for(int num : a){
                int radix = (num/n)%10;
                container[radix][counter[radix]] = num;
                counter[radix]++;
            }

            for(int i = 0;i < 10;i++){
                    if(counter[i] != 0){
                        for(int j = 0;j<counter[i];j++){
                            a[t] = container[i][j];
                            t++;
                        }
                    }
                counter[i] = 0;
            }

            t = 0;
            n *= 10;
        }
    }
    
    public static void main(String[] args){
        int[] a = {1,21,32,45,687,89,43,44,95};
        RadixSort.radixSort(a,1000);
        System.out.println(Arrays.toString(a));
    }
}
