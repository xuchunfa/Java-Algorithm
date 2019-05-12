package cn.xuchunfa.javapattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-09-16 21:20
 **/
public class InvocationHandlerImpl implements InvocationHandler {

   /* private Human human;

    public InvocationHandlerImpl(Human human) {
        this.human = human;
    }*/

    private Animal animal;

    public InvocationHandlerImpl(Animal animal) {
        this.animal = animal;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("dynamic proxy name: " + proxy.getClass());
        System.out.println("method: " + method.getName());
        System.out.println("args: " + Arrays.toString(args));

        System.out.println("--------start------------");
        Object proxyObject = method.invoke(animal,args);
        System.out.println("---------end----------");
        System.out.println();

        //返回代理对象
        return proxyObject;
    }
}
