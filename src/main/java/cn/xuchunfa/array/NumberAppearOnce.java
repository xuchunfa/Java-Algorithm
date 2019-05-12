package cn.xuchunfa.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 数组中只出现一次的数字,其余数字出现了两次
 * @author: Xu chunfa
 * @create: 2019-05-01 09:46
 **/
public class NumberAppearOnce {

    public void FindNumsAppearOnce(int[] array,int num1[] , int num2[]) {
        int temp = array[0];
        for(int i = 1;i < array.length;i++){
            temp ^= array[i];
        }
        int index = findLowBit1(temp);//异或结果中的最低位1的位置
        for(int i = 0;i < array.length;i++){
            if(lowBitIs0OR1(array[i],index)){//index处为0
                num1[0] ^= array[i];
            }else {//index处为1
                num2[0] ^= array[i];
            }
        }

    }

    private boolean lowBitIs0OR1(int num,int index) {
        return (num >> index & 1) == 0;
    }

    private int findLowBit1(int temp) {
        int index = 0;
        while ((temp&1) == 0 && index < 32){
            temp >>= 1;
            index++;
        }
        return index;
    }

    @Test
    public void test(){
        int[] nums = {2,2,3,3,1,4};
        int[] temp1 = {0};
        int[] temp2 = {0};
        FindNumsAppearOnce(nums,temp1,temp2);
        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
    }
}
