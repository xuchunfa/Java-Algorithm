import org.junit.Test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-25 20:14
 **/
public class TestLRU {
    @Test
    public void test(){
        LRUCache<String,Integer> lru = new LRUCache<>(3);
        lru.put("3",3);
        lru.put("2",2);
        lru.put("1",1);
        lru.get("2");
        lru.put("4",4);
        lru.print();
    }
}
