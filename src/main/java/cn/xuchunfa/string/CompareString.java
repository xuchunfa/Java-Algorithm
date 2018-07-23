package cn.xuchunfa.string;

/**
 * @description: 字符串引用和字符串的对比
 * @author: Xu chunfa
 * @create: 2018-07-13 12:15
 **/
public class CompareString {

    public static void main(String[] args){
        String str1 = null;
        String str2 = "";
        String str3 = new String();

        /*
        输出结果：
        * null


          true
        **/
        System.out.println(str1);//null
        System.out.println(str2);//空
        System.out.println(str3);//空

        System.out.println(str2.hashCode());//0
        System.out.println(str3.hashCode());//0

        /*
        * 结果：
        * false
        * false
        * 值和地址都不相同
        */
        System.out.println(str1 == str2);
        System.out.println(str2.equals(str1));

        /*
         * 结果：
         * false
         * true
         * 值相同，地址不相同
         */
        System.out.println(str2 == str3);
        System.out.println(str2.equals(str3));


        //常量池的问题
        String s1 = "ab";
        String s3 = "abc";
        String s4 = "ab" + "c";
        String s5 = s1 + "c";

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false


    }

}
