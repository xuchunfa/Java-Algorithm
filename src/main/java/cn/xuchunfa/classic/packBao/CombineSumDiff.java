package cn.xuchunfa.classic;

import org.junit.Test;

/**
 * @description: 组合数组元素，使和为指定数(其中每个数字只能使用一次,背包问题)
 *               输入：[1,4,2,4,6] sum = 10
 *               输出：3
 *               原因：[4,6]的坐标为(1,4)、(3,4)
 *                     [4,2,4]
 * @author: Xu chunfa
 * @create: 2019-07-27 21:18
 **/
public class CombineSumDiff {

    //优化空间复杂度为：O(target+1)
    public int findCombineOpt(int[] array,int target){

        if(array == null || array.length == 0 || target < 0)
            return 0;

        int[] dp = new int[target + 1];

        //只使用array[0]这一种面值的钱
        dp[0] = 1;
        for(int j = 1;j <= target;j++){
            dp[j] = (j == array[0] ? 1 : 0);
        }

        //背包问题的思想
        for(int i = 1;i < array.length;i++){
            for(int j = target;j - array[i] >= 0;j--){
                dp[j] += (j - array[i] >= 0 ? dp[j-array[i]] : 0);
            }
        }
        return dp[target];
    }

    @Test
    public void test(){
        int[] coins = {2,4,2,4,4};
        int target = 10;
        System.out.println(findCombineOpt(coins,target));
    }
}
