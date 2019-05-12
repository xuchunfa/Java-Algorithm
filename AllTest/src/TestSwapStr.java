import org.junit.Test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-12 15:48
 **/
public class TestSwapStr {

    @Test
    public void test(){
        String str = "abc";
        System.out.println(swap(str,0,1));
    }

    public String swap(String str,int l,int r){
        char temp = str.charAt(l);
        str = str.replace(str.charAt(l),str.charAt(r));
        str = str.replace(str.charAt(r),temp);
        return str;
    }
}
