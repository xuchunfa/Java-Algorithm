package cn.xuchunfa.dynamicProgram;

/**
 * @description: 剪绳子 把长度为 n 的绳子剪成 m 段(n > 1,m > 1)所有相乘乘积最小
 * @author: Xu chunfa
 * @create: 2018-08-06 19:23
 **/
public class CutStrip {

    public static int cutStrip(int length){
        if(length < 2)
            return 0;

        if(length == 2)
            return 1;
        if(length == 3)
            return 2;

        int[] result = new int[length+1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4;i<=length;i++){
            int max = 0;
            for(int j = 1;j<=i/2;j++){
                int temp = result[j]*result[i-j];
                if(temp > max)
                    max = temp;
            }
            result[i] = max;
        }

        return result[length];
    }

    public static void main(String[] args){
        System.out.println(CutStrip.cutStrip(10));
    }
}
