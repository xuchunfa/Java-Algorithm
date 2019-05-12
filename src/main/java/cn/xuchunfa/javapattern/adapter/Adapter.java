package cn.xuchunfa.javapattern.adapter;

/**
 * @description: 类适配器模式
 * @author: Xu chunfa
 * @create: 2018-11-08 10:08
 **/
public class Adapter extends Adaptee implements Target {

    public void method2() {
        System.out.println("现在我能使用method2()了");
    }
}
