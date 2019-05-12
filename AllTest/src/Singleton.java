/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-10 18:38
 **/
public class Singleton {

    private static final Singleton instance = new Singleton();
    private Singleton(){}

    public void say(){
        System.out.println("hello world");
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        try {
            //反射调用获取对象
            Singleton instance3 = (Singleton) Class.forName("Singleton").newInstance();
            System.out.println(instance1);
            System.out.println(instance3);
            System.out.println(instance1 == instance3);//false不相等
            instance1.say();
            instance3.say();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
