package cn.xuchunfa.javapattern.factory.simpleFactory.factoryMethod;

/**
 * @description: 增加 ProductC 只需要增加一个具体 ProductC 的类 和一个 具体工厂类 ProductCFactory
 * @author: Xu chunfa
 * @create: 2018-11-14 10:12
 **/
public class Test {

    @org.junit.Test
    public void test(){
        ProductFactory  pf =  new ProductAFactory();
        pf.createProduct().label();

        ProductFactory  pf1 =  new ProductBFactory();
        pf1.createProduct().label();
    }
}
