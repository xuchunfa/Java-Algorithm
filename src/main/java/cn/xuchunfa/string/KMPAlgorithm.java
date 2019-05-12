package cn.xuchunfa.string;

/**
 * @description: KMP算法
 * @author: Xu chunfa
 * @create: 2018-08-27 17:16
 **/
public class KMPAlgorithm {

    //时间复杂度：O(targetLen + patternLen)
    public static int resolve(String target,String pattern){

        int i,j;
        int targetLen = target.length();
        int patternLen = pattern.length();
        i = 0;
        j = 0;

        int[] next = findNext(pattern);

        while (i < targetLen && j < patternLen){
            if(j == -1 || target.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        //返回匹配坐标
        if(j == patternLen)
            return i - j;

        return -1;
    }

    private static int[] findNext(String pattern) {
        int length = pattern.length();

        int[] next = new int[pattern.length()];
        next[0] = -1;

        int k = -1;
        int j = 0;

        while (j < length - 1){

            //p[k]代表模式串的前缀 p[j]代表后缀
            if(k == -1 || pattern.charAt(k) == pattern.charAt(j)){
                k++;
                j++;

                //相当于p[k] = p[j]时 next[j+1] = next[j] + 1 这里的next[j]相当于没++之前的k
                //next[j] = k;

                //进一步优化举个例子"abacababc" 与 "abab" 匹配的例子,当c与第二个b不匹配时,第一个又会与c匹配一次
                if(pattern.charAt(j) == pattern.charAt(k)){//j和k都前移后 p[j] == p[k] 的情况
                    next[j] = next[k];
                }else {
                    next[j] = k;
                }


            }else {
                //如果P[0] != p[j]的话，那么k = -1重新开始匹配
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args){
        String t = "abacababc";
        String p = "abab";
        System.out.println(KMPAlgorithm.resolve(t,p));
    }
}
