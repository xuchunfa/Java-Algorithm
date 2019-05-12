package cn.xuchunfa.array;

/**
 * @description: 构建乘积数组(不允许使用除法)
 * @author: Xu chunfa
 * @create: 2019-05-05 16:27
 **/
public class MultiArray {

    public int[] multiply(int[] A) {
        if(A == null)
            throw new IllegalArgumentException("A = null");
        int length = A.length;
        int[] B = new int[length];
        if(length > 0){
            B[0] = 1;
            for(int i = 1;i < length;i++){//计算下三角每行的乘积
                B[i] = B[i-1]*A[i-1];
            }

            int temp = 1;
            for(int i = length - 2;i>=0;i--){
                temp *= A[i+1];//计算上三角每行的乘积
                B[i] *= temp;//计算每行最终的乘积
            }
        }
        return B;
    }
}
