package cn.xuchunfa.javapattern.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-09-06 21:25
 **/
public class SingletonTest {

    //饿汉模式
    private static final SingletonTest INSTANCE = new SingletonTest();

    private SingletonTest(){}

    public static SingletonTest getInstance() {
        return INSTANCE;
    }
    

    static class ThreadTest implements Runnable {
        //存放单例对象，使用Set是为了不存放重复元素
        public Set<SingletonTest> singles = new HashSet<SingletonTest>();

        public void run() {
            //获取单例
            SingletonTest s = SingletonTest.getInstance();
            //添加单例
            singles.add(s);
        }
    }

    //始终只产生一个单例
    public static void main(String[] args){
        ThreadTest t = new ThreadTest();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        System.out.println(t.singles);
    }
    
}
