package cn.xuchunfa.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @description: 桶排序
 * @author: Xu chunfa
 * @create: 2019-04-13 11:59
 **/

/*
 *  时间复杂度：(k代表桶的数量)
 *    最好：O(n + k)
 *    最坏：O(n^2)
 *    平均：O(n + k)
 *  空间复杂度：
 *    O(1)
 *  稳定性：
 *    稳定
 * */
public class BucketSort {

    public void bucketSort(int[] array){
        if(array == null)
            return;

        int length = array.length;
        int min = array[0];
        int max = array[0];
        for(int i = 1;i < length;i++){
            if(array[i] < min){
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
        }
        int bucketNum = length;//桶的个数等于原数组的长度
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketNum);
        for(int i = 0;i < bucketNum;i++){//初始化桶
            buckets.add(new ArrayList<>());
        }
        for(int i = 0;i < length;i++){
            int index = (array[i] - min)*(bucketNum - 1)/(max - min);//按比例放入到桶里
            //int h;
            //int hash = (h = Integer.valueOf(array[i]).hashCode()) ^ (h >>> 16);
            //int index = hash & (bucketNum - 1);
            buckets.get(index).add(array[i]);
        }

        for(int i = 0;i < bucketNum;i++){//每个桶进行排序
            Collections.sort(buckets.get(i));
        }

        int start = 0;
        for(ArrayList bucket : buckets){
            for(int i = 0;i < bucket.size();i++){
                array[start++] = (int) bucket.get(i);
            }
        }
    }

    @Test
    public void test(){
        int[] a = {9,5,6,7,3,8,1};
        bucketSort(a);
        System.out.println(Arrays.toString(a));
    }
}
