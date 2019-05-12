package cn.xuchunfa.string;

/**
 * @description: 字符串匹配模式(.和 *)
 * @author: Xu chunfa
 * @create: 2018-08-15 13:31
 **/
public class RegularExpression {

    public static boolean match(String str,String pattern,int strLen,int patternLen,int strIndex,int patternIndex){
        if(str == null || pattern == null){
            return false;
        }

        return matchCore(str,pattern,strLen,patternLen,strIndex,patternIndex);
    }

    private static boolean matchCore(String str, String pattern,int strLen,int patternLen,int strIndex,int patternIndex) {

        if(strIndex == strLen && patternIndex == patternLen){
            return true;
        }

        //模式匹配完了字符串没匹配完
        if(strIndex < strLen && patternIndex == patternLen){
            return  false;
        }

        //模式的第二个字符为'*'的情况
        if(patternIndex+1 < patternLen && pattern.charAt(patternIndex + 1) == '*'){//注意边界条件最后一个字符,需要判断条件
            if(strIndex < strLen && str.charAt(strIndex) == pattern.charAt(patternIndex) || strIndex < strLen && pattern.charAt(patternIndex) == '.'){

                //先匹配（包括了 * 匹配0到多个字符的情况）
                return matchCore(str,pattern,strLen,patternLen,strIndex,patternIndex+2) ||
                        matchCore(str,pattern,strLen,patternLen,strIndex+1,patternIndex);


            }else {//字符串匹配完了模式还没匹配完

                //strIndex = strLen 模式中直接跳过 *
                return matchCore(str,pattern,strLen,patternLen,strIndex,patternIndex+2);
            }
        }

        //模式的第二个字符不为'*'的情况(注意条件 strIndex < strLen )
        if(strIndex < strLen && str.charAt(strIndex) == pattern.charAt(patternIndex) || (strIndex < strLen && pattern.charAt(patternIndex) == '.')){
            return matchCore(str,pattern,strLen,patternLen,++strIndex,++patternIndex);
        }

        //包含了str="ab" pattern="...."的情况了
        //strIndex = strLen 模式中没有 * 匹配失败
        return false;
    }

    public static void main(String[] args){
        String str = "aab";
        String pattern = ".*aab";
        int strLen = str.length();
        int patternLen = pattern.length();
        System.out.println(RegularExpression.match(str,pattern,strLen,patternLen,0,0));
    }

}
