package cn.xuchunfa.javapattern.simpleproxy;

/**
 * @description: Proxy角色
 * @author: Xu chunfa
 * @create: 2019-05-23 10:05
 **/
public class Agent implements Subject {

    private Subject actor;

    public Agent(Subject actor) {
        this.actor = actor;
    }

    @Override
    public void perform() {
        System.out.println(getClass().getSimpleName() + ": 负责接戏");
        actor.perform();
    }
}
