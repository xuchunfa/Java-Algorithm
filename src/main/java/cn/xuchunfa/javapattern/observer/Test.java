package cn.xuchunfa.javapattern.observer;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 16:06
 **/
public class Test {

    public static void main(String[] args){
        //公众号的名字
        String theme = "侃球";
        String message = "勇士大胜76人";
        User user = new User("xuchunfa");
        User user1 = new User("snoopdog");
        PublicMessage publicMessage = PublicMessage.getInstance();//单例模式
        publicMessage.setName(theme);
        publicMessage.setMessage(message);

        user.subscribe(theme);
        user1.subscribe(theme);

        //user.subscribe(publicMessage);
        //user1.subscribe(publicMessage);

        //公众号发布消息
        publicMessage.publishNotice();
    }
}
