package cn.xuchunfa.bitOperation;

import org.junit.Test;

/**
 * @description: 位运算符进行四则运算
 * @author: Xu chunfa
 * @create: 2019-05-04 15:48
 **/
public class BitArithmetic {

    //加法
    public int add(int num1,int num2){
        int carry,sum;
        do{
            sum = num1 ^ num2;//异或=无进位的求和

            //左移运算符高于&
            //&=求进位
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (carry != 0);

        return num1;
    }

    //减法(加法的变形)
    public int sub(int num1,int num2){
        //减数的补码 机器中负数由补码表示 补码=取反 + 1
        int complement;
        complement = add(~num2,1);
        return add(num1,complement);
    }

    //乘法
    public int multi(int num1,int num2){
        int multiplicand = num1 < 0 ? add(~num1,1) : num1;
        int multiplier = num2 < 0 ? add(~num2,1) : num2;

        //绝对值求乘积
        int result = 0;
        while (multiplier > 0){
            if((multiplier & 0x1) > 0){
                result = add(result,multiplicand);
            }
            multiplicand <<= 1;
            multiplier >>= 1;
        }

        //判断最高位
        if((num1 ^ num2) < 0){//异号
            result = add(~result,1);
        }

        return result;
    }

    //除法
    public int div(int num1,int num2){
        int dividend = num1 < 0 ? add(~num1,1) : num1;//被除数
        int divisor = num2 < 0 ? add(~num2,1) : num2;//除数
        int quotient,remainder;
        quotient = 0;
        remainder = 0;
        for(int i = 31; i > 0; i--){
            if((dividend >> i) >= divisor){
                quotient = add(quotient,1 << i);
                dividend =sub(dividend,divisor << i);
            }
        }
        if((num1 ^ num2) < 0){
            quotient = add(~quotient,1);
        }

        remainder = dividend;
        return quotient;
    }

    @Test
    public void test(){
        //System.out.println(add(-3,-9));
        //System.out.println(sub(3,9));
        System.out.println(multi(-3,-9));
    }
}
