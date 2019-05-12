package cn.xuchunfa.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description: 字符串的全排列问题
 * 输入："abc"
 * 输出：按字典顺序排序
 *      abc,acb,bac,bca,cab,cba
 * @author: Xu chunfa
 * @create: 2019-04-12 15:32
 **/
public class AllPermutation {

    private ArrayList<String> allPermutation = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0)
            return allPermutation;
        Collections.sort(find(str,0,str.length()-1));
        return allPermutation;
    }

    public ArrayList<String> find(String str,int l,int r) {
        if(l == r){
            if(!allPermutation.contains(str)){
                allPermutation.add(str);
            }
        }else {
            for(int i = l;i <= r;i++){
                str = swap(str,l,i);
                find(str,l+1,r);
                str = swap(str,l,i);
            }
        }
        return allPermutation;
    }

    private String swap(String str, int l, int i) {
        char[] chars = str.toCharArray();
        char leftChar =  chars[l];
        chars[l] = chars[i];
        chars[i] = leftChar;
        return String.valueOf(chars);
    }

    @Test
    public void test(){
        String s = "abc";
        System.out.println(Permutation(s));
    }
}
