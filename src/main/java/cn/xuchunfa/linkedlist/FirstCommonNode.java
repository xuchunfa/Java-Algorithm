package cn.xuchunfa.linkedlist;


import java.util.Stack;

/**
 * @description: 两个链表的第一个公共节点
 * @author: Xu chunfa
 * @create: 2019-04-18 11:36
 **/
public class FirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (pHead1 != null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode node = null;
        while (!s1.isEmpty() && !s2.isEmpty() && s1.peek().data == s2.peek().data){
            node = s1.pop();
            s2.pop();
        }
        return node;
    }
}
