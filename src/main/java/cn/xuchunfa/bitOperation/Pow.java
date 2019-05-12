package cn.xuchunfa.bitOperation;

/**
 * @description: 指数a的n次幂
 * @author: Xu chunfa
 * @create: 2018-08-11 14:31
 **/
public class Pow {

    public static double pow(double base,int exp){

        if(Double.doubleToLongBits(base) == Double.doubleToLongBits(0.00) && exp == 0){
            return 0.0;
        }

        //浮点数的比较
        if(Double.doubleToLongBits(base) == Double.doubleToLongBits(0.00) && exp < 0){
            throw new RuntimeException("参数不合法");
        }

        double result;
        int absExp;
        if(exp < 0){
            absExp = -exp;
        }else {
            absExp = exp;
        }

        result = calPow(base,absExp);
        if(exp < 0){
            result = 1.0/result;
        }

        return result;
    }

    private static double calPow(double base, int exp) {

        if(exp == 0)
            return 1;

        if(exp == 1)
            return base;

        //位移运算代替除法
        double result = calPow(base,exp/2);
        result *= result;

        //与运算代替取余
        if((exp & 1) == 1){
            result *= base;
        }

        return result;
    }

    //只考虑正数情况
    public static double iterativeCalPow(double base, int exp){
        double res = 1;
        while (exp > 0){
            if((exp & 1) != 0){
                res = base*res;
            }
            res = res*res;
            exp = exp >> 1;
        }
        return  res;
    }

    public static double allCalPow(double base, int exp){
        if(exp == 0)
            return 1;

        if(exp == 1)
            return base;

        double result = allCalPow(base,exp/2);

        if((exp & 1) == 0){
            result *= result;
        }else {
            if(exp > 0){
                result = base*result*result;
            }else {
                result = result*result*1/base;
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(Pow.iterativeCalPow(2,6));
    }
}
