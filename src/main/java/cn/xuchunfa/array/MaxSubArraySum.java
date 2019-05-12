package cn.xuchunfa.array;

/**
 * @description: 数组最大子序列和
 * @author: Xu chunfa
 * @create: 2018-08-27 10:06
 **/
public class MaxSubArraySum {

    public static int resolve(int[] array){

        if(array == null || array.length == 0)
            return 0;

        int sum = array[0];
        int maxSum = array[0];
        for(int i = 1;i < array.length;i++){
            sum += array[i];
            if(sum > maxSum){
                maxSum = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] arr = {-1,-4,-7};
        System.out.println(MaxSubArraySum.resolve(arr));
    }
}
