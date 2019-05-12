package cn.xuchunfa.string;

/**
 * @description: 字符串暴力匹配算法
 * @author: Xu chunfa
 * @create: 2018-08-27 16:54
 **/
public class BFAlgorithm {

    public static boolean match(String target,String pattern){
        int i,j,k;
        k = 0;
        i = k;
        j = 0;
        boolean result = false;

        while (i < target.length() && j < pattern.length()){
            if(target.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                k++;
                i = k;
                j = 0;
            }
        }

        if(j == pattern.length())
            //如果返回匹配坐标的话 return i - pattern.length();
            result = true;

        return result;
    }

    public static void main(String[] args){
        String t = "ababcababa";
        String p = "ababf";
        System.out.println(BFAlgorithm.match(t,p));
    }
}
