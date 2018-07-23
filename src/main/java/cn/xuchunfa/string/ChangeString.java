package cn.xuchunfa.string;

/**
 * @description: 可变字符串对象 才能改变 String 对象
 * @author: Xu chunfa
 * @create: 2018-07-20 09:43
 **/
public class ChangeString {

    public static void main(String[] args){

        //可变字符串对象
        StringBuffer sb = new StringBuffer("abc");

        change(sb);

        System.out.println(sb);
    }

    private static void change(StringBuffer sb) {
        sb.append("dfg");
    }


}
