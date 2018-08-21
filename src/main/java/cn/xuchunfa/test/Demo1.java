package cn.xuchunfa.test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-21 19:59
 **/
public class Demo1 {

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "abcd";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
    }
}
