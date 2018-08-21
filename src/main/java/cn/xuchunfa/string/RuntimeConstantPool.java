package cn.xuchunfa.string;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-14 20:43
 **/
public class RuntimeConstantPool {

    public static void main(String[] args){

        String str = new StringBuilder("我").append("18").toString();
        String str1 = new StringBuilder("ja").append("va").toString();

        System.out.println(str.intern() == str);//true 只是在常量池中记录首次出现的实例引用
        System.out.println(str1.intern() == str1);//false 执行StringBuilder.toString()已经出现过"java"字符串,所以intern()返回常量池中的引用
    }
}
