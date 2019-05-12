package cn.xuchunfa.array;

import static cn.xuchunfa.sort.QuickSort.partition;

/**
 * @description: 数组中超过一半长度的数
 * @author: Xu chunfa
 * @create: 2018-08-24 09:36
 **/
public class MoreThanHalfNumber {

    //检查中间位置的数出现的次数是否大于数组长度的一半
    private static boolean check(int[] num, int result) {
        boolean flag = false;
        int count = 0;

        for(int k = 0;k < num.length;k++){
            if(num[k] == result){
                count++;
            }
        }

        if(count > num.length/2){
            flag = true;
        }

        return flag;
    }

    //通过遍历数组的方法,时间复杂度:O(n)
    public static int findNumOther(int[] num,int length){
        int result = num[0];
        int times = 1;
        for(int i = 1;i < length;i++){
            if(times == 0){
                result = num[i];
                times = 1;
            }else if(num[i] == result){
                times++;
            }else {
                times--;
            }
        }

        if(check(num,result)){
            return result;
        }

        return 0;
    }

    public static void main(String[] args){
        int[] num = {2,5,3,2,2,1,2};
        int length = num.length;
        int result = MoreThanHalfNumber.findNumOther(num,length);

        if(check(num,result)){
            System.out.println("TrueResult = " + result);
        }else {
            System.out.println("WrongResult = "+ 0);
        }


    }

}
