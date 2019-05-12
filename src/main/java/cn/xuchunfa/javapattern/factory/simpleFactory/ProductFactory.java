package cn.xuchunfa.javapattern.factory.simpleFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 09:52
 **/
public class ProductFactory {

    public static Product createProduct(String name){
        if("A".equals(name)){
            return new ProductA();
        }else if("B".equals(name)){
            return new ProductB();
        }else {
            throw new RuntimeException("No Product");
        }
    }

}
