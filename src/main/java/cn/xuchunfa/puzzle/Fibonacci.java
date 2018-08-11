package cn.xuchunfa.puzzle;

/**
 * @description: 斐波拉契数列的第 n 位
 * @author: Xu chunfa
 * @create: 2018-07-27 18:56
 **/
public class Fibonacci {

    //效率差
    public static long fibonacci1(int n){

        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        return fibonacci1(n-1) + fibonacci1(n-2);

    }

    //时间复杂度O(n)
    public static long fibonacci(int n){

        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        long one = 0;
        long two = 1;
        long three = 0;
        for(int i = 2;i<=n;i++){
            three = one + two;
            one = two;
            two = three;
        }

        return three;
    }

    public static void main(String[] args){
        System.out.println(Fibonacci.fibonacci(10));
    }
}
