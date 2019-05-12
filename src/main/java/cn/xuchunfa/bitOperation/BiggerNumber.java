package cn.xuchunfa.bitOperation;

import org.junit.Test;

/**
 * @description:  判断大于n的最小2的n次方的整数
 * @author: Xu chunfa
 * @create: 2019-04-01 15:43
 **/
public class BiggerNumber {

    public int find(int n){
        if(n == 0 || ((n-1)&n) == 0){
            return n;
        }
        int flag = 1;
        while (flag < n){
            flag <<= 1;
        }
        return flag;
    }

    //最快的办法
    public int find1(int n){
        n--;
        n |= n >> 1;//右移优先于或
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;
        return n;
    }

    //小于n的最小2的n次方的整数
    public int small(int n){
        int result = 0;
        for(int i = n;i >= 1;i--){
            if((i-1 & i) == 0){
                result = i;
                break;
            }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(small(0));
    }
}
