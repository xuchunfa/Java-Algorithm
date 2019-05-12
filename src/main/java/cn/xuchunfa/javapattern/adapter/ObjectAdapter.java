package cn.xuchunfa.javapattern.adapter;

/**
 * @description: 对象适配器
 * @author: Xu chunfa
 * @create: 2018-11-08 10:20
 **/

//如果Target是抽象类的话,只能用这种
public class ObjectAdapter implements Target{

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    public void method1() {
        this.adaptee.method1();
    }

    //缺点：如果目标接口很多，但用到的比较少，重写起来比较麻烦
    public void method2() {
        System.out.println("要适配的目标方法");
    }
}
