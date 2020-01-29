package cn.xuchunfa.responsibility;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-05-25 21:12
 **/
public abstract class Handler {
    protected String name;
    private Handler next;


    public final void transfer(String problem){
        //if(problem.equals(Problem.STUCTURE)){
        //
        //}
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract void report();
}
