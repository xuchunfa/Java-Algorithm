package cn.xuchunfa.puzzle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description: 滑动窗口中的最大值
 * @author: Xu chunfa
 * @create: 2019-05-08 14:32
 **/
public class MaxValueInWindow {

    //时间复杂度：O(n)
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0 || size < 1 || size > num.length){
            return  result;
        }

        for(int i = 0;i < num.length;i++){
            if(!queue.isEmpty()){
                if(i >= queue.peek() + size){//队头元素已超出滑动窗口
                    queue.poll();
                }
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]){//保证队头元素保存最大元素的下标
                    queue.removeLast();
                }
            }
            queue.offer(i);

            //先把元素装满滑动窗口再取值
            if(i + 1 >= size){//队头元素即窗口最大值
                result.add(num[queue.peek()]);
            }
        }

        return result;
    }

    @Test
    public void test(){
        int[] nums = {1,2,8,4,7,6};
        System.out.println(maxInWindows(nums,3));
    }
}
