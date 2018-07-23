package cn.xuchunfa.javapattern.singleton;

/**
 * @description: 单例模式
 * @author: Xu chunfa
 * @create: 2018-07-17 15:19
 **/
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton(){}

    //DCL
    public static Singleton getInstance(int i) {
        System.out.println("Thread-" + i);
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    System.out.println("Thread-" + i + " get instance");
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }


    //静态方法
    /*private Singleton(){}

    private static class Holder{
        private static Singleton instance =  new Singleton();
    }

    public static Singleton getInstance(int i){

        System.out.println("Thread-" + i + " get instance");
        return Holder.instance;
    }*/

}
