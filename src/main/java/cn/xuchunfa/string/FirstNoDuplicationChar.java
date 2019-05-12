package cn.xuchunfa.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串中第一个不重复出现的字符
 * @author: Xu chunfa
 * @create: 2019-04-17 21:06
 **/
public class FirstNoDuplicationChar {

    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        Map<Character,Integer> table = new HashMap<>();
        for(int i = 0;i < str.length();i++){
            int counter;
            if(table.get(str.charAt(i)) == null){//key不存在
                counter = 1;
            }else {
                counter = table.get(str.charAt(i)) + 1;
            }
            table.put(str.charAt(i),counter);
        }

        for(int i = 0; i < str.length();i++){
            if(table.get(str.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    @Test
    public void test(){
        //String s = "ggolle";
        //System.out.println(FirstNotRepeatingChar(s));
        Map<String,Integer> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.containsKey(null));
        System.out.println(map.get("1"));//到底是key不存在？还是key存在value=null？
    }
}
