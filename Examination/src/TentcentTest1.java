import org.junit.Test;
import org.w3c.dom.CDATASection;

import java.util.Scanner;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-05 19:27
 **/
public class TentcentTest1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String parameter = in.nextLine();
        String[] strs = parameter.split("\\s");

        //要组合的最大数
        int combinedValue = Integer.parseInt(strs[0]);


        int coinValueNum =  Integer.parseInt(strs[1]);
        int[] allCoinValue = new int[coinValueNum];
        for(int i = 0;i < coinValueNum;i++){
            allCoinValue[i] = in.nextInt();//组合需要的数
        }

        //int result = findSolution(combinedValue,allCoinValue);
        //System.out.println(result);
    }

    private int findSolution(int combinedValue, int[] allCoinValue) {

        return -1;
    }

}
