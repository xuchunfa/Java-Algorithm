package cn.xuchunfa.javapattern.simpleproxy;

/**
 * @description: RealSubject角色
 * @author: Xu chunfa
 * @create: 2019-05-23 10:02
 **/
public class Actor implements Subject {
    @Override
    public void perform() {
        System.out.println(getClass().getSimpleName() + ": 负责演戏");
    }
}
