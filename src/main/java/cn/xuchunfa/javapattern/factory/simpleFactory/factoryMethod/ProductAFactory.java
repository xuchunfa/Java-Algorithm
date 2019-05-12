package cn.xuchunfa.javapattern.factory.simpleFactory.factoryMethod;

import cn.xuchunfa.javapattern.factory.simpleFactory.Product;
import cn.xuchunfa.javapattern.factory.simpleFactory.ProductA;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 10:10
 **/
public class ProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
