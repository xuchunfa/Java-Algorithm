package cn.xuchunfa.puzzle;

/**
 * @description: 青蛙可以跳一级台阶和二级台阶,跳上 n 级台阶共有多少种跳法
 * @author: Xu chunfa
 * @create: 2018-07-27 21:36
 **/
public class FrogStep {

    public static long solution(int n) {

        if (n == 0) {
            throw new RuntimeException("输入自然数");
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        long one = 1;
        long two = 2;
        long three = 0;
        for (int i = 3; i <= n; i++) {
            three = one + two;
            one = two;
            two = three;
        }

        return three;
    }

    public static void main(String[] args){
        System.out.println(FrogStep.solution(100));
    }
}
