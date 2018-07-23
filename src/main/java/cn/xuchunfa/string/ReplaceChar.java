package cn.xuchunfa.string;

/**
 * @description: 用 20% 代替字符串中的 ' '
 * @author: Xu chunfa
 * @create: 2018-07-20 11:22
 **/
public class ReplaceChar {

    //时间复杂度：O(n) 空间复杂度：O(n)
    public void replace(char[] a,int len){

        //len = 1 时就一个字符'\0'
        if(a == null || len<2){
            System.out.println("输入长度大于0的字符串");
            System.exit(-1);
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

        if(newLen > len)
            return;

        int i = oldLen;//从'\0'开始
        int j = newLen;

        while (i >= 0 && i < j){

            if(a[i] == ' '){
                a[j--] = '0';
                a[j--] = '2';
                a[j--] = '%';
            }else {
                //注意 j 越界的情况
                a[j--] = a[i];
            }

            i--;
        }
    }

    public static void main(String[] args) {

        String s = "abcd";

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

        new ReplaceChar().replace(newChar,totalLen);

        for(int i = 0;newChar[i] != '\0';i++){
            System.out.print(newChar[i]);
        }

    }

}
