package cn.xuchunfa.hashTable;

/**
 * @description: 找到字符串中第一个只出现一次的字符
 * @author: Xu chunfa
 * @create: 2018-08-30 20:49
 **/
public class FindDupChar {

    public static char resolve(String str){

         if(str == null){
             throw new RuntimeException("输入字符串");
         }

         int[] charCounter = new int[256];
         int strLen = str.length();
         int i = 0;

         //计数统计，数组实现哈希表
         for(;i < strLen;i++){
             charCounter[str.charAt(i)]++;
         }

         //第二次遍历原来的字符串
         for(i = 0;i < strLen;i++){
             if(charCounter[str.charAt(i)] == 1)
                 return str.charAt(i);
         }

         //ASCII值为0
         return '\0';
    }

    public static void main(String[] args){
        System.out.println((int) FindDupChar.resolve(""));
    }
}
