package cn.xuchunfa.string;

import java.awt.geom.QuadCurve2D;

/**
 * @description: 用 20% 代替字符串中的 ' '
 * @author: Xu chunfa
 * @create: 2018-07-20 11:22
 **/
public class ReplaceChar {

    //时间复杂度：O(n) 空间复杂度：O(n)
    public static void replace(char[] a,int len){

        //len = 1 时就一个字符'\0'
        if(a == null || len<2){
            System.out.println("输入长度大于0的字符串");
            return;
        }

        int oldLen = 0;
        int count = 0;
        int newLen;
        for(int i = 0;a[i] !='\0';i++){
            if(a[i] == ' ')
                count++;
            oldLen++;
        }
        newLen = oldLen + 2*count;
        //判断输入与字符数组的不匹配的字符串长度
        if(newLen > len)
            return;

        int j = newLen - 1;
        for(int i = oldLen-1;i >= 0;i--) {
            if (a[i] == ' ') {
                a[j--] = '0';
                a[j--] = '2';
                a[j--] = '%';
            } else {
                //注意 j 越界的情况
                a[j--] = a[i];
            }
        }
    }

    public static void main(String[] args) {

        String s = "we are champion";

        //多了个'\0'
        char oldChar[] = new char[s.length()+1];

        int counter = 0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == ' ')
                counter++;
            oldChar[i] = s.charAt(i);
        }

        //字符串结束标志
        oldChar[s.length()] = '\0';

        //里面已经包含了'\0'结束符
        int totalLen = oldChar.length + counter*2;

        //数组扩容
        char[] newChar = new char[totalLen];
        for(int i = 0;i<oldChar.length;i++){
            newChar[i] = oldChar[i];
        }

        ReplaceChar.replace(newChar,totalLen);

        for(int i = 0;newChar[i] != '\0';i++){
            System.out.print(newChar[i]);
        }

    }

}
