package cn.xuchunfa.queue;

import java.util.Stack;

/**
 * @description: 自定义栈 O(1)时间内返回最小值
 * @author: Xu chunfa
 * @create: 2019-04-03 09:59
 **/
public class MinStack {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> assistStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if(assistStack.isEmpty() || node < assistStack.peek()){
            assistStack.push(node);
        }else {
            assistStack.push(assistStack.peek());
        }
    }

    public void pop() {
        if(!dataStack.isEmpty() && !assistStack.isEmpty()){
            dataStack.pop();
            assistStack.pop();
        }
    }

    public int top() {
        if(dataStack.isEmpty())
            throw new RuntimeException("error: stack is empty");

        return dataStack.peek();
    }

    public int min() {
        if(assistStack.isEmpty()){
            throw new RuntimeException("error: stack is empty");
        }
        return assistStack.peek();
    }
}
