import org.junit.Test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-05-01 20:02
 **/
public class TestStringIntern {
    @Test
    public void test1(){
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);


        String s4 = "22";
        String s3 = new String("2") + new String("2");
        System.out.println(s3.intern() == s3);
        System.out.println(s3.intern() == s4);
        s3.intern();
        System.out.println(s3 == s4);
    }

    @Test
    public void test(){

    }
}
