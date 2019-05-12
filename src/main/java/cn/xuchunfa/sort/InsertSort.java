package cn.xuchunfa.sort;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: 插入排序(插入排序)
 * @author: Xu chunfa
 * @create: 2018-07-28 19:21
 **/
/*
 *  时间复杂度：
 *    最好：O(n)
 *    最坏：O(n2)
 *  空间复杂度：
 *    O(1)
 *  稳定性：
 *    稳定
 * */
public class InsertSort {

    public static void insert(int[] a){
        if(a == null){
            throw new RuntimeException("输入数组");
        }

        if(a.length <= 1){
            return;
        }

        for(int j = 1;j<a.length;j++){
            int temp = a[j];
            int i;

            for(i = j-1;i>=0 && a[i]>temp;i--){
                a[i+1] = a[i];
            }

            //or
            /*for(i = j;i-1 >= 0 && a[i-1] > temp;i--){
                a[i] = a[i-1];
                a[i-1] = temp;
            }*/

            //不满足上面for循环的话,元素不动
            a[i+1] = temp;
        }
    }

    public static void main(String[] args){
        int[] a = {6,5,4,3,2,1};
        InsertSort.insert(a);
        System.out.println(Arrays.toString(a));
    }

}
