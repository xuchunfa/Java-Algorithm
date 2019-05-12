package cn.xuchunfa.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-26 15:45
 **/
public class SumOfKnumber {

    public static void findKNumber(int sum, int n, int[] combine,int index){

        //index 最大取到 n
        if(index > n || index > sum)
            return;

        if(index == sum){
            combine[index-1] = index;
            printResult(combine);

            //还可以作为其他组合的元素
            combine[index-1] = 0;
            return;
        }

        //选择i
        combine[index-1] = index;
        findKNumber(sum-index, n, combine, index+1);

        //i被放弃
        combine[index-1] = 0;
        findKNumber(sum,n,combine,index+1);


    }

    private static void printResult(int[] combine) {

        for(int i = 0;i < combine.length;i++){
            if(combine[i] != 0){
                System.out.print(combine[i] + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args){

        int[] combine = new int[7];
        SumOfKnumber.findKNumber(10,7,combine,1);
    }
}
