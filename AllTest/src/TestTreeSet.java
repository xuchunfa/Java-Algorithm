import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-17 09:50
 **/
public class TestTreeSet {
    public static void main(String[] args){
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("ab");
        for(String s : set){
            System.out.println(s);
        }
    }
}
