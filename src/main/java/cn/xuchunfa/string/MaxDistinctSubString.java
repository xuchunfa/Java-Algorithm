package cn.xuchunfa.string;

/**
 * @description: 不含重复字符的最长公共子串
 * @author: Xu chunfa
 * @create: 2018-08-27 11:40
 **/
public class MaxDistinctSubString {

    //返回字符串长度
    public static String resolve(String str,int length){

        if(str == null || length < 0){
            throw new RuntimeException("参数非法");
        }

        int distance;
        int currentLen = 0;
        int maxLen = 0;

        //用来存放字符在字符串中的最近访问的index
        int[] judgeExisted = new int[256];
        for(int j = 0;j < judgeExisted.length;j++){
            judgeExisted[j] = -1;
        }

         int startIndex = 0;

        for(int i = 0;i < length;i++){

            //所有字符0~255
            int index =str.charAt(i);

            //字符没出现过
            if(judgeExisted[index] < 0){
                currentLen = currentLen + 1;
            }else {
                distance = i - judgeExisted[index];
                if(distance <= currentLen){//字符出现在子串的中间
                    currentLen = distance;
                }else {//d > currentLen
                    currentLen = currentLen + 1;
                }
            }

            //更新出现字符的坐标
            judgeExisted[index] = i;

            if(currentLen > maxLen){
                maxLen = currentLen;
                //如果出现了重复的字符的话,i会一直前进但maxLen不会变,所以满足条件时,startIndex已经跳过了出现重复的字符。
                startIndex = i + 1 - maxLen;
            }
        }

        return str.substring(startIndex,startIndex + maxLen);
    }

    //时间复杂度O(n2)
    public static String find(String str,int len){
        int maxLen = 0;
        String maxStr = null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < len;i++){
            for(int j = i;j < len;j++){
                if(sb.toString().indexOf(str.charAt(j)) == -1){
                    sb.append(str.charAt(j));
                }else {
                    break;
                }
            }
            if(sb.length() > maxLen){
                maxStr = sb.toString();
                maxLen = sb.length();
            }else {
                sb.replace(0,sb.length()-1,"");
            }
        }
        return maxStr;
    }

    public static String findDistinctStr(String str){
        int currentLen = 1;
        int maxLen = 1;
        int[] visited = new int[256];
        for(int i = 0;i < visited.length;i++){
            visited[i] = -1;
        }
        visited[str.charAt(0)] = 0;
        int startIndex = 0;
        for(int i = 1;i < str.length();i++){
            int prevIndex = visited[str.charAt(i)];
            if(visited[str.charAt(i)] == -1 || i - prevIndex > currentLen){
                currentLen++;
            }else {
                if(currentLen > maxLen){
                    maxLen = currentLen;
                    startIndex = i - maxLen;//重新计算开始坐标
                }
                currentLen = i - prevIndex;//新的子串长度
            }
            visited[str.charAt(i)] = i;
        }

        //遍历完字符串
        if(currentLen > maxLen){
            maxLen = currentLen;
            startIndex = str.length() - maxLen;//重新计算开始坐标d
        }
        return str.substring(startIndex,startIndex + maxLen);
    }

    public static void main(String[] args){
        String str = "fbbbcdegf";
        System.out.println(MaxDistinctSubString.findDistinctStr(str));
        System.out.println(MaxDistinctSubString.resolve(str,str.length()));
    }
}
