package cn.xuchunfa.javapattern.proxy.dynamicProxy;

import cn.xuchunfa.javapattern.proxy.staticProxy.DataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-13 16:22
 **/
public class MyProxy implements InvocationHandler {

    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("close")){
            //System.out.println("代理类的名字：" + proxy.getClass());
            DataSource.getDataSource().recoveryConnection((Connection) target);
            return null;
        }else {
            return method.invoke(target,args);
        }
    }

}
