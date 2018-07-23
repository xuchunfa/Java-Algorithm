package cn.xuchunfa.string;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-13 12:44
 **/
public class CompareString1 {
    
    public static void main(String[] args){
        /*
        * 当创建一个常量对象时先判断 常量池是否存在相同内容的常量
        * 如果存在就不再继续创建 而是将找到常量的引用给要创建的字符串常量,他们其实是一个对象
        * */
        String str1 = "hello";
        String str2 = "hello";

        String str3 = new String("hello");
        String str4 = new String("hello");

        System.out.println(str1 == str2);//true 是因为常量池
        System.out.println(str3 == str4);//false


        /*
        * 那是因为 常量池中本身存在"123" 这个字符串对象
        * 在执行new String("123" ) 时只是将常量池中的"123"复制到堆中
        * 然后对象的引用 交给str3  这其实就是两个字符串对象  一个 在常量池 一个在堆中  所以运行结果为false
        * */
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals(str4));//true



    }
}
