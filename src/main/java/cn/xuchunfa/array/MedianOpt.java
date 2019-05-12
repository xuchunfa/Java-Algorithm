package cn.xuchunfa.array;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-08-24 16:13
 **/
public class MedianOpt {

    //默认自然排序（升序）
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    //降序时传入比较器
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;

    public void insert(Integer num){

        if((count & 1) == 0){//长度为偶数，插入minHeap
            maxHeap.offer(num);
            int selectedMax = maxHeap.poll();
            minHeap.offer(selectedMax);
        }else {//长度为奇数，插入maxHeap
            minHeap.offer(num);
            int selectedMin = minHeap.poll();
            maxHeap.offer(selectedMin);
        }

        count++;
    }

    public double getMedian(){

        return minHeap.size() == maxHeap.size() ? (maxHeap.poll()+minHeap.poll())/2.0 : minHeap.poll();
    }

    public static void main(String[] args){
        MedianOpt test = new MedianOpt();
        for(int i = 0;i < 50;i++){
            test.insert(i);
        }

        System.out.println(test.getMedian());
    }

}
