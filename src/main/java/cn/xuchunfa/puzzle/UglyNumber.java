package cn.xuchunfa.puzzle;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description: 给定索引位置的丑数（有序排列的）
 * @author: Xu chunfa
 * @create: 2018-08-30 16:50
 **/
public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if(index < 7)
            return index;

        int p2,p3,p5,minNum;
        ArrayList<Integer> uglyNums = new ArrayList<>();
        p2 = 0;
        p3 = 0;
        p5 = 0;
        minNum = 1;
        uglyNums.add(minNum);
        while (uglyNums.size() < index){
            minNum = Math.min(uglyNums.get(p2)*2,Math.min(uglyNums.get(p3)*3,uglyNums.get(p5)*5));
            uglyNums.add(minNum);
            if(minNum == uglyNums.get(p2)*2)
                p2++;
            if(minNum == uglyNums.get(p3)*3)
                p3++;
            if(minNum == uglyNums.get(p5)*5)
                p5++;
        }
        return minNum;
    }

    @Test
    public void test(){
        System.out.println(GetUglyNumber_Solution(10));
    }

}
