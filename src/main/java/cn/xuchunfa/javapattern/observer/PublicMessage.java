package cn.xuchunfa.javapattern.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 15:35
 **/
public class PublicMessage extends Observable {

    private String name;//公众号的名字

    private String message;//发布的消息

    public PublicMessage(){

    }

    public PublicMessage(String name){
        this.name = name;
    }

    public PublicMessage(String name,String message) {
        this.name = name;
        this.message = message;
    }

    public void publishNotice(){
        System.out.println("发布了消息：" + message);
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //单例模式
    public static PublicMessage getInstance(){
        return Holder.publicMessage;
    }

    static class Holder{
        public static final PublicMessage publicMessage = new PublicMessage();
    }

}
