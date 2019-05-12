package cn.xuchunfa.string;

import org.junit.Test;

/**
 * @description: 判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author: Xu chunfa
 * @create: 2019-05-06 09:50
 **/
public class JudgeNumric {

    public boolean isNumeric(char[] str) {
        boolean sign = false;//+ - 标识符
        boolean decimal = false;//小数点
        boolean hasE = false;//e标识符
        if(str == null)
            return false;
        int length = str.length;
        int i = 0;
        while (i < length){
            if(str[i] == 'e' || str[i] == 'E'){
                if(hasE)
                    return false;
                if(!hasE && (i + 1 == length) || !hasE && i == 0)//e的前面和后面都需要接数字
                    return false;

                hasE = true;
            }else if(str[i] == '+' || str[i] == '-'){
                if(sign && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                if(!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E')//非首位的+-标识符
                    return false;
                if(i + 1 == length)//符号位 + - 后面必须接数字
                    return false;

                sign = true;

            }else if(str[i] == '.'){
                if(decimal || hasE)
                    return false;

                if(i + 1 == length)//符号位 . 后面必须接数字
                    return false;
                if(i == 0 || i > 0 && (str[i-1] == '+' || str[i-1] == '-'))//符号位 . 前面必须接数字
                    return false;
                decimal = true;
            }else if(str[i] < '0' || str[i] > '9')
                return false;

            i++;
        }
        return true;
    }

    //偷懒方法
    public boolean isNumericOther(char[] str) {
        try {
            double d = Double.parseDouble(String.valueOf(str));
        }catch (NumberFormatException exp){
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        //System.out.println(isNumeric("-1.34".toCharArray()));
        System.out.println(isNumericOther("".toCharArray()));
    }
}
