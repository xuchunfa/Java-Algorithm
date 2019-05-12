import java.util.*;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-13 20:59
 **/
public class JDTest2 {
    public static void main(String[] args) {

        SortedMap<Integer,Integer> treeMap = new TreeMap<>();
        Scanner in = new Scanner(System.in);

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int allnum = Integer.valueOf(in.nextLine());

        for(int i = 0;i<allnum-1;i++){

            String[] strs = in.nextLine().split(" ");
            int a = Integer.valueOf(strs[0]);
            int b = Integer.valueOf(strs[1]);
            if(b == 1){
                int n = treeMap.size();
                treeMap.put(n,1);
                hashMap.put(a,n);

            }
            else {
                int sign = hashMap.get(b);
                hashMap.put(a,sign);
                treeMap.put(sign,treeMap.get(sign)+1);
            }
        }
        System.out.println(Collections.max(treeMap.values()));
    }
}

