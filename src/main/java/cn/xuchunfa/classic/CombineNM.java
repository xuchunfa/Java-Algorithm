package cn.xuchunfa.classic;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * 输入：5,6               输入：5，6
 * 输出：                  正确输出：
 *      1 1 1 1 1 1            1 1 1 1 1 1
 *      1 1 1 1 2              1 1 1 1 2
 *      1 1 1 3                1 1 1 3
 *      1 1 2 2                1 1 2 2
 *      1 1 4                  1 1 4
 *      1 5                    1 2 3
 *      2 1 1 1 1 重复了       1 5
 *      2 1 1 2                2 2 2
 *      2 1 3                  2 4
 *      2 2 1 1                3 3
 *      2 2 2
 *      2 3 1
 *      2 4
 *      ....
 *
 * @author: Xu chunfa
 * @create: 2019-04-07 10:46
 **/
public class CombineNM {
    private ArrayList<Integer> path = new ArrayList<Integer>();
    public void findPath(int num,int sum,int i){
        if(sum < 0)
            return;

        if(sum == 0){
            for(int j = 0;j < path.size();j++){
                System.out.print(path.get(j) + " ");
            }
            System.out.println();
        }

        while (i < num && sum - i - 1 >= 0){
            path.add(i+1);
            findPath(num,sum-i-1,i);
            i++;
            path.remove(path.size()-1);
        }
    }

    @Test
    public void test(){
        findPath(5,6,0);
    }
}
