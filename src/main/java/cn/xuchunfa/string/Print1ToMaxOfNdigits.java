package cn.xuchunfa.string;

/**
 * @description: 打印从1到最大的n位数
 * @author: Xu chunfa
 * @create: 2018-08-11 19:36
 **/
public class Print1ToMaxOfNdigits {

    public static void print1ToMaxOfNdigits(int n){

        if(n <= 0){
            throw new RuntimeException("参数非法");
        }

        char[] nums = new char[n+1];
        nums[n] = '\0';

        for(int i = 0;i<10;i++){
            nums[0] = (char) (i + '0');
            everyBigitRecursive(nums,n,0);
        }
    }

    private static void everyBigitRecursive(char[] nums, int length, int index) {

        if(index == length-1){
            printNum(nums);
            return;
        }

        for(int i = 0;i<10;i++){

            //向个位递进
            nums[index + 1] = (char) (i + '0');
            everyBigitRecursive(nums,length,index+1);
        }
    }

    private static void printNum(char[] nums) {

        boolean isBegin0 = true;

        for(int i = 0;i < nums.length;i++){
            if(isBegin0 && nums[i] != '0')
                isBegin0 = false;

            if(!isBegin0){
                System.out.print(nums[i]);
            }
        }

        System.out.println();
    }
    
    public static void main(String[] args){
        Print1ToMaxOfNdigits.print1ToMaxOfNdigits(1);
    }
}
