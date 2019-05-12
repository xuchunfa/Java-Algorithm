package cn.xuchunfa.javapattern.adapter;

/**
 * @description: 要代理的对象
 * @author: Xu chunfa
 * @create: 2018-11-08 10:09
 **/


public class Adaptee {

    public void method1(){
        System.out.println("被代理的对象");
    }

    public void method3(){
        System.out.println("自己独特的方法");
    }

}
