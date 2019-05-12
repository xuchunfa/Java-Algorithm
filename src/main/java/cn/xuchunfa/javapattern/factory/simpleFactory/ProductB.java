package cn.xuchunfa.javapattern.factory.simpleFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 09:51
 **/
public class ProductB implements Product {
    @Override
    public void label() {
        System.out.println("Product B");
    }
}
