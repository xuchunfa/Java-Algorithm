package cn.xuchunfa.classic;

import org.junit.Test;

/**
 * @description: 0-1背包问题
 *               输入：
 *                  Weight  1   2   3
 *                  value   6   10  12
 *                  背包容量：5
 *               输出最大价值：22
 * @author: Xu chunfa
 * @create: 2019-07-28 20:12
 **/
public class PackageProblem {

    //时间和空间复杂度都为：O(weight.length * capacity)
    public int maxValue(int[] weight,int[] value,int capacity){
        int[][] dp = new int[weight.length][capacity+1];

        for(int i = 0;i <= capacity;i++){
            //每件物品只能拿一次
            dp[0][i] = (i < weight[0] ? 0 : value[0]);
        }

        for(int i = 1;i < weight.length;i++){
            for(int j = 0;j <= capacity;j++){
                //不装第i个物品
                dp[i][j] = dp[i-1][j];
                //装第i个物品
                if(j - weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length-1][capacity];
    }

    //优化空间复杂度都为：O(capacity)
    public int maxValueOpt(int[] weight,int[] value,int capacity){
        int[] dp = new int[capacity+1];
        //初始化第一行
        for(int i = 0;i <= capacity;i++){
            dp[i] = (i < weight[0] ? 0 : value[0]);
        }

        for(int i = 1;i < weight.length;i++){
            //从后往前覆盖
            //for(int j = capacity;j >= weight[i];j--){
            //    dp[j] = Math.max(dp[j],dp[j - weight[i]]+value[i]);
            //}
            for(int j = 0;j <= capacity;j++){
                if(j - weight[i] >= 0){
                    dp[j] = Math.max(dp[j],dp[j - weight[i]]+value[i]);
                }
            }
        }
        return dp[capacity];
    }

    @Test
    public void test(){
        int[] weight = {1,2,3};
        int[] value = {6,10,12};
        int cap = 5;

        System.out.println(maxValue(weight,value,cap));
        System.out.println(maxValueOpt(weight,value,cap));
    }
}
