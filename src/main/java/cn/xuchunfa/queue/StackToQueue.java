package cn.xuchunfa.queue;

import java.util.Queue;
import java.util.Stack;

/**
 * @description: 两个栈实现队列
 * @author: Xu chunfa
 * @create: 2018-07-26 11:13
 **/
public class StackToQueue<T> {

    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T element){
        stack1.push(element);
    }

    public T deleteHead(){
        if(stack2.size() <= 0){
            while(!stack1.empty()){
                T element = stack1.pop();
                stack2.push(element);
            }
        }

        //说明stack1 也没元素了
        if(stack2.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        T head = stack2.pop();
        return head;
    }
    
    public static void main(String[] args){
        StackToQueue<Integer> queue = new StackToQueue<Integer>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        Integer a = queue.deleteHead();
        queue.appendTail(4);
        Integer b = queue.deleteHead();
        System.out.println(b);
    }
}
