package cn.xuchunfa.javapattern.proxy;

/**
 * @description: 精英
 * @author: Xu chunfa
 * @create: 2018-09-17 11:06
 **/
public class PriorHuman implements Animal {

    public void eat(String food) {
        System.out.println("eat " + food);
    }

    public void sleep(String address) {
        System.out.println("sleep at " + address);
    }
}
