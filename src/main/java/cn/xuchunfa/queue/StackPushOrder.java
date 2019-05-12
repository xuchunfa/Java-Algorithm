package cn.xuchunfa.queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 入栈序列和出栈序列是否匹配
 * @author: Xu chunfa
 * @create: 2019-04-03 11:18
 **/
public class StackPushOrder {

    public boolean IsPopOrder(int[] pushA,int[] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }
        int length = pushA.length;
        int popIndex = 0;
        Stack<Integer> assit = new Stack<>();
        for(int i = 0; i < length;i++){
            assit.push(pushA[i]);

            while (!assit.isEmpty() && assit.peek() == popA[popIndex] && popIndex < length){
                assit.pop();
                popIndex++;
            }
        }
        return  popIndex == length;
    }
    @Test
    public void test(){
        int[] push = {1,3,2,5};
        int[] pop = {3,1,2,5};
        System.out.println(IsPopOrder(push,pop));
    }
}
