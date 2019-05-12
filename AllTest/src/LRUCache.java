

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-25 19:47
 **/
public class LRUCache<K,V> {
    private static final float LOADER = 0.75f;
    private final int CACHESIZE;
    private LinkedHashMap<K,V> map;
    public LRUCache(int cacheSize) {
        this.CACHESIZE = cacheSize;
        this.map = new LinkedHashMap<K,V>(cacheSize,LOADER,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CACHESIZE;
            }
        };
    }

    public synchronized V get(K k){
        return map.get(k);
    }

    public synchronized void put(K k,V v){
        map.put(k,v);
    }

    public synchronized void print(){
        Iterator<Map.Entry<K,V>> it = map.entrySet().iterator();
        while (it.hasNext()){
            System.out.print(it.next().getKey() + " ");
        }
        System.out.println();
    }

}
