package cn.xuchunfa.puzzle;

/**
 * @description: 小偷偷珠宝问题
 * @author: Xu chunfa
 * @create: 2018-08-10 13:06
 **/
public class ThiefProblem {

    static int max(int a, int b) { return (a > b)? a : b; }

    //基于递归的解法
    static int knapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                knapSack(W, wt, val, n-1)
        );
    }

    //基于动态规划的解法
    static int maxValue(int W, int wt[], int val[], int n)
    {

       int[][] itemToValue = new int[n+1][W+1];

       for(int i = 0;i<W+1;i++){
           itemToValue[0][i] = 0;
       }

       for(int j = 0;j<n+1;j++){
           itemToValue[j][0] = 0;
       }


       for(int i = 1;i<=n;i++){
            for(int j = 1;j<=W;j++){
                int weightPlus = j - wt[i-1];
                if(weightPlus < 0){
                    itemToValue[i][j] = itemToValue[i-1][j];
                }else {
                    itemToValue[i][j] = max(itemToValue[i-1][j],itemToValue[i-1][weightPlus]+val[i-1]);
                }

            }
       }
       return itemToValue[n][W];
    }

    public static void main(String[] args){
        int[] value = {6,3,5,4,6};
        int[] weight = {2,3,6,5,7};
        int maxWeight = 10;
        int n = value.length;

        //System.out.println(ThiefProblem.maxValue(value,weight,maxWeight));
        System.out.println(ThiefProblem.knapSack(maxWeight,weight,value,n));
    }
}
