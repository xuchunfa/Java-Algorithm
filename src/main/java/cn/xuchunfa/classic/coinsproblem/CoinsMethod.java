package cn.xuchunfa.classic;

import org.junit.Test;

/**
 * @description: 换钱的方法数 And 输出每种换钱的面值组合 And 每种币值可以重复使用
 *
 *               coins[] = {5,10,25,1} 都为正数且不重复
 *               target = 15;
 *               Methods:
 *                      {1,1,1,...,1}
 *                      {1,1,1,..,5}
 *                      {1,1,1,1,1,5,5}
 *                      {1,1,1,1,1,10}
 *                      {5,5,5}
 *                      {5,10}
 * @author: Xu chunfa
 * @create: 2019-07-27 15:30
 **/
public class CoinsMethod {

    //时间复杂度:O(target*N) 空间复杂度：O(target*N)
    public int findCombine(int[] array,int target){

        if(array == null || array.length == 0 || target < 0)
            return 0;


        //dp[i][j] i表示使用array[i]面值的钱,j表示要换的钱
        int[][] dp = new int[array.length][target + 1];
        for(int i = 0;i < array.length;i++){
            //所有面值都不用
            dp[i][0] = 1;
        }

        //只使用array[0]这一种面值的钱
        for(int j = 1;j*array[0] <= target;j++){
            dp[0][j*array[0]] = 1;
        }

        for(int i = 1;i < array.length;i++){
            for(int j = 1;j <= target;j++){

                //dp[i-1][j] 使用0张面值为array[i]的情况
                dp[i][j] = dp[i-1][j];


                //它们的求和 = dp[i][j-array[i]]
                //dp[i-1][j - 1*array[i]] 使用1张
                //dp[i-1][j - 2*array[i]] 使用2张
                //.....
                //dp[i-1][j - k*array[i]] 使用k张 j - k*array[i] <= target
                dp[i][j] += (j - array[i] >= 0 ? dp[i][j-array[i]] : 0);
            }
        }
        return dp[array.length - 1][target];
    }

    //优化空间复杂度为：O(target+1)
    public int findCombineOpt(int[] array,int target){

        if(array == null || array.length == 0 || target < 0)
            return 0;

        int[] dp = new int[target + 1];

        //只使用array[0]这一种面值的钱
        //并且每种面值可以重复使用
        for(int j = 0;j*array[0] <= target;j++){
            dp[j*array[0]] = 1;
        }

        for(int i = 1;i < array.length;i++){
            for(int j = 1;j <= target;j++){
                dp[j] += (j - array[i] >= 0 ? dp[j-array[i]] : 0);
            }
        }
        return dp[target];
    }

    @Test
    public void test(){
        int[] coins = {5,10,25,1};
        int target = 15;
        System.out.println(findCombine(coins,target));
        System.out.println(findCombineOpt(coins,target));
    }
}
