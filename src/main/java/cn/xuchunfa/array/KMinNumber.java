package cn.xuchunfa.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 数组中最小的 k个数
 * @author: Xu chunfa
 * @create: 2019-04-13 10:43
 **/
public class KMinNumber {

    private PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private ArrayList<Integer> nums = new ArrayList<>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length == 0 || k <= 0 || k > input.length){
            return  nums;
        }
        int length = input.length;
        int queueLen = k;
        for(int i = 0;i < queueLen;i++){
            queue.offer(input[i]);
        }
        int start = queueLen;
        while (start < length){
            int maxNum = queue.peek();
            if(maxNum > input[start]){
                queue.poll();
                queue.offer(input[start]);
            }
            start++;
        }
        for(int i = 0;i < queueLen;i++){
            nums.add(queue.poll());
        }
        Collections.sort(nums);
        return nums;
    }

    @Test
    public void test(){
        int[] a = {3,7,5,2,1,8};
        System.out.println(GetLeastNumbers_Solution(a,3));
    }
}
