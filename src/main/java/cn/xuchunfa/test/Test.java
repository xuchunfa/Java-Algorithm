package cn.xuchunfa.test;

public class Test {

    public void test(String s){
        s = "world";
    }

    public static void main(String[] args){

        String str = "we are JRs";

        String a = str.replace(" ","%20");

        System.out.println(a);
        System.out.println(str);

    }
}
