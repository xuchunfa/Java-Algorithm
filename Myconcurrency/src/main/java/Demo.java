/**
 * @description: 匿名类
 * @author: Xu chunfa
 * @create: 2018-07-17 20:51
 **/


interface People {
    public abstract void eat();
}

public class Demo {
    public static void main(String[] args) {
        People p = new People() {
            public void eat() {
                System.out.println("I can eat ");
            }
        };
        p.eat();
    }
}


