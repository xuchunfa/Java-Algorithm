package cn.xuchunfa.array;

import java.util.Arrays;

import static cn.xuchunfa.sort.QuickSort.partition;

/**
 * @description: 找出中位数
 * @author: Xu chunfa
 * @create: 2018-08-24 14:52
 **/
public class Median {

    public static double findMedian(int num[],int length){
        int middle = length >> 1;
        int start = 0;
        int end = length-1;
        double result = 0.0;

        int position = partition(num,start,end);

        //改变数组的顺序
        while(position != middle){
            if(position < middle){
                position = partition(num,position+1,end);
            }else {
                position = partition(num,start,position-1);
            }
        }

        //&的优先级没!=高,但是比||和&&高
        if((length & 1) != 0){
            result = num[middle];
        }else {
            Arrays.sort(num,start,middle);
            result = (num[middle-1] + num[middle])/2.0;
        }

        return result;
    }

    public static void main(String[] args){
        int[] num = {1,1,1,1,1,1};
        System.out.println(Median.findMedian(num,num.length));
    }
}
