package cn.xuchunfa.javapattern.adapter;

/**
 * @description: 缺省适配器模式
 * @author: Xu chunfa
 * @create: 2018-11-08 10:33
 **/
public class AbsentAdapter implements Target {

    //提供空的实现，以后继承要用哪个就覆盖哪个
    public void method1() {

    }

    public void method2() {

    }
}
