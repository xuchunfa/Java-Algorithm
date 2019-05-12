package cn.xuchunfa.javapattern.factory.simpleFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 09:50
 **/
public class ProductA implements Product {
    @Override
    public void label() {
        System.out.println("Product A");
    }
}
