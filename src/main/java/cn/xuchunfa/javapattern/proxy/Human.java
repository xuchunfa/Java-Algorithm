package cn.xuchunfa.javapattern.proxy;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-09-16 21:11
 **/
public class Human implements Animal {

    public void eat(String food) {
        System.out.println("Human eat " + food);
    }

    public void sleep(String address) {
        System.out.println("Human sleep at " + address);
    }

}
