package cn.xuchunfa.string;

import org.junit.Test;

/**
 * @description: 翻转字符串单词
 * @author: Xu chunfa
 * @create: 2019-05-01 18:40
 **/
public class ReverseWords {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,str.length() - 1);
        int i = 0;
        int start,end;
        while (i < chars.length){
            while (i < chars.length && chars[i] == ' '){
                i++;
            }
            start = i;
            end = start;
            while (i < chars.length && chars[i] != ' '){
                end++;
                i++;
            }
            reverse(chars,start,end-1);
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test(){
        String s = "I  love you so much";
        System.out.println(ReverseSentence(s));
    }
}
