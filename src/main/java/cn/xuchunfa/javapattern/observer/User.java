package cn.xuchunfa.javapattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 15:33
 **/
public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    //订阅公众号
    public void subscribe(String name){
        PublicMessage.getInstance().addObserver(this);
    }

    //public void subscribe(PublicMessage publicMessage){
    //        publicMessage.addObserver(this);
    //    }

    //取消订阅公众号
    public void unsubscribe(String name){
        PublicMessage.getInstance().deleteObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof PublicMessage){
            PublicMessage publicMessage = (PublicMessage) o;
            System.out.println(name + " 收到了公众号的消息："+ publicMessage.getMessage());
        }
    }
}
