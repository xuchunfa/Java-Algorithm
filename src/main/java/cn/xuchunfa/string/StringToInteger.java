package cn.xuchunfa.string;

import org.junit.Test;

public class StringToInteger {

    public static int vary(String s) {

        int i = 0;
        int len = s.length();
        int result = 0;
        int radix = 10;
        boolean negative = false;//默认正数
        int limit = -Integer.MAX_VALUE;//-2147483647

       /* if(s == null){
            System.out.println("null");
            return -1;
        }*/

        if (s == null || s.length() == 0) {
            System.out.println("字符串不能为空!");
            return -1;
        }

        if (len > 0) {
            char firstChar = s.charAt(i);

            //判断第一个字符是不是正负号

                if (firstChar < '0') {
                if (firstChar == '-') {
                    limit = Integer.MIN_VALUE;//-2147483648
                    negative = true;
                } else if (firstChar != '+') {
                    System.out.println("非法字符!");
                    return -1;
                }

                if (len == 1) {
                    System.out.println("非法格式");
                    return -1;
                }
                i++;
            }

            //用于判断result < Integer.MIN_VALUE 的情况!!!
            int flag = limit/radix;

            //接着开始循环
            while (i < len) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int digit = ch - '0';

                    //类似于-21474836411 和 21474836423 这种情况
                    //-2147483641 < -214748364 以及 -2147483642 < -214748364
                    if(result < flag){
                        System.out.println("越界!");
                        return -1;
                    }
                    //这里result定义的为int型,有可能越界
                    result = result * radix;
                    if (result - digit < limit) {
                        System.out.println("越界!");
                        return -1;
                    }
                    result -= digit;

                } else {
                    System.out.println("非法字符!");
                    return -1;
                }
                i++;
            }
        }
        //结束 if(len > 0)
        return negative ? result : -result;
    }

    public int StrToInt(String str) {
        if(str == null || str.trim().equals("")){
            return 0;
        }
        int i = 0;
        boolean isPositive = true;
        long result = 0;
        int radix = 10;
        if(str.length() > 0){
            char firstChar = str.charAt(0);
            if(firstChar < '0'){
                if(firstChar == '+'){
                    isPositive = true;
                }else if(firstChar == '-'){
                    isPositive = false;
                }else {
                    return 0;//其他符号位
                }
                i++;
            }
            if(str.length() == 1){//就只有符号位
                return 0;
            }
        }
        while (i < str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return 0;
            }
            int digit = str.charAt(i) - '0';
            result = isPositive ? result = result*radix + digit : result*radix - digit;
            if(isPositive && result > 0x7fffffff || !isPositive && result < 0x80000000){
                return 0;
            }
            i++;
        }
        return (int) result;
    }

    @Test
    public void test(){
        System.out.println(StrToInt("-1"));
    }

    public static void main(String[] args) {
        String s = "";
        //String s = "";
        //String s = "123aaa";
        //String s = "2147483647";
        //String s = "2147483648";
        //String s = "2147483641222";
        //String s = "21474";
        //String s = "-1";
        //String s = "-2147483648";
        //String s = "-2147483649";
        //String s = "-2147483641";

        //System.out.println(StringToInteger.vary(s));
    }
}
