package cn.xuchunfa.bitOperation;

/**
 * @description: 计算二进制中的1的个数
 * @author: Xu chunfa
 * @create: 2018-08-06 21:44
 **/
public class Count1 {

    //循环次数为num的位数
    public static int count2(int num){

        int count = 0;
        int flag = 1;

        while (flag != 0){
            if((num & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int count1(int num){
        int count = 0;

        while (num != 0){
            num = num & num-1;
            count++;
        }

        return count;
    }

    //
    public static void main(String[] args){
        System.out.println(Count1.count2(-3));
    }
}
