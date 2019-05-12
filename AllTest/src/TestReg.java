import org.junit.Test;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-05-05 21:12
 **/
public class TestReg {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;

        return matchCore(str,0,pattern,0);
    }

    public boolean matchCore(char[] str, int strIndex,char[] pattern,int patternIndex)
    {
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }

        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }

        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if(strIndex != str.length && str[strIndex] == pattern[patternIndex] ||
                    strIndex != str.length && pattern[patternIndex] == '.') {
                return matchCore(str,strIndex,pattern,patternIndex + 2) ||
                        matchCore(str,strIndex+1,pattern,patternIndex);
            }else{//strIndex = str.length 为 * 的情况
                return matchCore(str,strIndex,pattern,patternIndex+2);//跳过*
            }
        }

        if(strIndex != str.length && str[strIndex] == pattern[patternIndex] ||
                strIndex != str.length && pattern[patternIndex] == '.'){
            return  matchCore(str,strIndex+1,pattern,patternIndex+1);
        }

        //strIndex = str.length 而且 还不为*的情况
        return false;
    }

    @Test
    public void test(){
        //System.out.println(match("ab".toCharArray(),"abcd".toCharArray()));
        System.out.println(5e+1);
    }
}
