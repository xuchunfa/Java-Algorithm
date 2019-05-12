package cn.xuchunfa.javapattern.adapter;

import org.junit.Test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 10:42
 **/
public class AbsentAdaptee extends AbsentAdapter {

    public void method3(){
        System.out.println("自己的方法");
    }

    //AbsentAdapter中为空的实现，这里进行覆盖
    public void method1(){
        System.out.println("适配的目标方法");
    }


    @Test
    public void test(){
        AbsentAdaptee absentAdaptee = new AbsentAdaptee();
        absentAdaptee.method1();
    }
}
