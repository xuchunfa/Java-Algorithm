package cn.xuchunfa.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-18 21:47
 **/
public class Demo {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private static int i;

    private void safeCount(){
        for(;;){

            i =  atomicI.get();
            boolean suc = atomicI.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }

    public static void main(String[] args){
        new Demo().safeCount();
        System.out.println(i);
    }
}
