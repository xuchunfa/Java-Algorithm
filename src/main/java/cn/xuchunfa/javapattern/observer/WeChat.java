package cn.xuchunfa.javapattern.observer;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 15:43
 **/
public class WeChat {

    public static PublicMessage getPublicMessage(String name){
        return new PublicMessage(name);
    }
}
