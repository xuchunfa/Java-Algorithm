
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-13 18:27
 **/
public class JDTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int strNum = in.nextInt();
        in.nextLine();
        String[] strs = new String[strNum];
        for(int i = 0;i < strNum;i++){
            String str = in.nextLine();
            strs[i] = str;
        }
        String target = in.nextLine();
        int result = findMaxNum(strs,target);
        System.out.println(result);
    }

    private static int findMaxNum(String[] strs, String target) {
        int length = target.length();
        Set<String> allSubStrs = new HashSet<String>();
        for(int i = 0;i < length;i++){
            for(int j = i+1;j <= length;j++){
                String sub = target.substring(i,j);
                allSubStrs.add(sub);
            }
        }

        Iterator<String> iterator = allSubStrs.iterator();
        for(int i = 0; i < allSubStrs.size();i++){
            boolean flag = false;
            String str = iterator.next();
            for(int j = 0;j < strs.length;j++){
                if(str.equals(strs[j])){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                iterator.remove();
                i--;
            }
        }
        return allSubStrs.size();
    }
}
