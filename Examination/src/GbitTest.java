import sun.security.provider.Sun;

import java.util.Scanner;

/**
 * @description: 数组中最小序列和
 * @author: Xu chunfa
 * @create: 2019-04-10 18:49
 **/
public class GbitTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        String elements = in.nextLine();
        String[] strs = elements.split("\\s+");
        int[] arrays = new int[strs.length];
        for(int i = 0;i < num;i++){
            arrays[i] = Integer.parseInt(strs[i]);
        }

        //int result = findMin(arrays);
        int result = findMax(arrays);
        System.out.println(result);
    }

    //时间复杂度：O(n)
    private static int findMin(int[] arrays) {
        int sum,minSum;
        sum = 0;
        minSum = 0;
        for(int i = 0;i < arrays.length;i++){
            sum += arrays[i];
            if(sum < minSum){
                minSum = sum;
            }else if(sum > 0) {
                sum = 0;
            }
            //minSum < sum < 0 继续下个元素求和
        }
        return minSum;
    }

    private static int findMax(int[] arrays) {
        int sum = 0,maxSum = 0;
        for(int i = 0;i < arrays.length;i++){
            sum += arrays[i];
            if(sum > maxSum){
                maxSum = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        return  maxSum;
    }




}
