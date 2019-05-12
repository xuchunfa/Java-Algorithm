package cn.xuchunfa.javapattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-09-16 21:16
 **/
public class MainProxy {

    public static void main(String[] args) throws Throwable {

        //Animal human = new Human();

        Animal human = new PriorHuman();

        //PriorHuman human = new PriorHuman();

        ClassLoader classLoader = human.getClass().getClassLoader();

        Class[] interfaces = human.getClass().getInterfaces();


        InvocationHandler handler = new InvocationHandlerImpl(human);
        Animal proxy = (Animal) Proxy.newProxyInstance(classLoader,interfaces, handler);

        System.out.println(proxy.getClass().getName());

        //proxy.eat("rice");
        //proxy.sleep("house");

        proxy.eat("hotdog");
        proxy.sleep("Big house");

        /*if(proxy instanceof MyProxy){
            InvocationHandler handlerTest = MyProxy.getInvocationHandler(proxy);
            handlerTest.invoke(proxy,human.getClass().getMethod("eat"), new String[]{"hotdog"});
        }*/
    }
}
