package cn.xuchunfa.javapattern.simpleproxy;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-05-23 10:09
 **/
public class Client {
    public static void main(String[] args){
        Subject actor = new Actor();
        Agent proxy = new Agent(actor);
        proxy.perform();
    }
}
