package cn.xuchunfa.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description 两个队列实现栈
 * @author: Xu chunfa
 * @create: 2018-07-27 11:34
 **/
public class QueueToStack<T> {

    Queue<T> queue1 = new LinkedList<T>();
    Queue<T> queue2 = new LinkedList<T>();

    public void push(T element){
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(element);
            return;
        }

        if(!queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(element);
            return;
        }

        if(queue1.isEmpty() && !queue2.isEmpty()){
            queue2.offer(element);
            return;
        }
    }

    public T pop(){
        T result = null;
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("栈空");
        }

        //小心:当执行poll操作后,size就自动减1了
        if(!queue1.isEmpty() && queue2.isEmpty()){
            while (queue1.size() > 1){
                T element = queue1.poll();
                queue2.offer(element);
            }
            result = queue1.poll();
            return result;
        }

        if(queue1.isEmpty() && !queue2.isEmpty()){
            while (queue2.size() > 1){
                T element = queue2.poll();
                queue1.offer(element);
            }
            result = queue2.poll();
            return result;
        }

        return result;
    }

    public static void main(String[] args){
        QueueToStack<Integer> stack = new QueueToStack<Integer>();
        stack.push(1);
        Integer b = stack.pop();
        System.out.println(b);
    }
}
