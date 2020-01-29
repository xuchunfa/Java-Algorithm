package cn.xuchunfa.classic;

import org.junit.Test;

/**
 * @description: 完全背包问题，物品可以拿多次
 *               输入：
 *                  Weight  1   2   3
 *                  value   6   10  12
 *               背包容量：5
 *               输出最大价值：30
 * @author: Xu chunfa
 * @create: 2019-07-29 18:55
 **/
public class CompletePackageProblem {

    //优化空间复杂度都为：O(capacity)
    public int maxValueOpt(int[] weight,int[] value,int capacity){
        int[] dp = new int[capacity+1];

        for(int i = 0;i < weight.length;i++){
            //j从weight[i]开始
            for(int j = weight[i];j <= capacity;j++){
                dp[j] = Math.max(dp[j],dp[j - weight[i]]+value[i]);
            }
        }
        return dp[capacity];
    }

    @Test
    public void test(){
        int[] weight = {1,2,3};
        int[] value = {6,10,12};
        int cap = 5;

        System.out.println(maxValueOpt(weight,value,cap));
    }
}
