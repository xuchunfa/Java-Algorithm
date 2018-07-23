package cn.xuchunfa.javapattern.singleton;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-17 15:44
 **/
public class MyThread extends Thread {

    private int anInt;


    public MyThread(int i){
        this.anInt = i;
    }


    @Override
    public void run() {
        Singleton.getInstance(anInt);
    }

    public static void main(String[] args){
        for(int i = 0;i<10;i++){
            new MyThread(i).start();
        }
    }
}
