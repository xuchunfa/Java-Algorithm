package cn.xuchunfa.puzzle;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 数据流中的中位数
 * @author: Xu chunfa
 * @create: 2019-05-08 09:55
 **/
public class StreamMedian {

    //Min(min) >= Max(max) 且两者元素个数之差不超过1
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void insert(Integer num) {
        if(max.size() == 0){
            max.offer(num);
            return;
        }
        if(max.size() == min.size() + 1){//保证元素之差为1
            if(num >= max.peek()){
                min.offer(num);
            }else {
                min.offer(max.poll());
                max.offer(num);
            }
        }else {
            if(num <= min.peek()){
                max.offer(num);
            }else {
                max.offer(min.poll());
                min.offer(num);
            }
        }
    }

    //未优化
    public double GetMedian() {
        return ((max.size() + min.size()) & 1) == 0 ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }

    @Test
    public void test(){
        insert(4);
        insert(3);
        insert(3);
        insert(4);
        insert(4);
        insert(5);
        System.out.println(GetMedian());
    }
}
