package cn.xuchunfa.classic;

import java.util.LinkedList;

/**
 * @description: 圆圈中最后留下来的数（约瑟夫环）
 * @author: Xu chunfa
 * @create: 2019-05-04 10:32
 **/
public class JosephCycle {

    //链表思路
    public int LastRemaining_Solution(int n, int m) {
        if(m < 1)
             throw new IllegalArgumentException("m < 1");

        LinkedList<Integer> cycle = new LinkedList<>();
        for(int i = 0;i < n;i++){
            cycle.offer(i);
        }
        int removeIndex = 0;//开始报数的位置
        while (cycle.size() > 1){
            removeIndex = (removeIndex + m - 1) % cycle.size();
            cycle.remove(removeIndex);
        }
        return cycle.size() == 1 ? cycle.get(0) : -1;
    }

    //递推思路
    public int OptLastRemaining_Solution(int n, int m) {
        if(m < 1 || n < 1)
            return -1;

        int predecessor = 0;//n=1的话返回0
        for(int i = 2;i <= n;i++){
            predecessor = (predecessor + m) % i;
        }
        return predecessor;
    }

}
