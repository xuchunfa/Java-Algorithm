import java.util.Scanner;

/**
 * @description: 切分数组,每个子数组的和要最小
 * @author: Xu chunfa
 * @create: 2019-07-23 16:43
 **/
public class ShoppeeMN1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String param = in.nextLine();
        String[] strs = param.split("\\s+");
        int maxValue = Integer.valueOf(strs[0]);
        int segment = Integer.valueOf(strs[1]);

        //输入小于等于maxValue的值
        String all = in.nextLine();
        String[] single = all.split("\\s+");
        long[] array = new long[single.length];
        for(int i = 0;i < single.length;i++){
            array[i] = Long.valueOf(single[i]);
        }

        

    }
}
