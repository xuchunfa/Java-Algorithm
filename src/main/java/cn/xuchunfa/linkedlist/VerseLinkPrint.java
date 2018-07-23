package cn.xuchunfa.linkedlist;

import java.util.Stack;

/**
 * @description: 从尾到头打印链表
 * @author: Xu chunfa
 * @create: 2018-07-22 15:02
 **/
public class VerseLinkPrint {

    private ListNode head;

    private ListNode q;

    //添加链表节点
    public void add(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else {
            this.head.addNode(node);
        }
    }

    //从头到尾打印链表节点
    public void print(){
        if(this.head == null){
            System.out.println("链表为空");
        }else {
            this.head.printNode();
            System.out.println();
        }
    }

    //从尾到头打印链表节点(常规方法) 时间复杂度(O(n)) 空间复杂度(O(1))
    public void versePrint(){

        if(head == null){
            System.out.println("链表为空");
            return;
        }

        //已经改变的链表的结构
        ListNode p = head.next;
        ListNode q = null;
        head.next = null;

        while (p != null){
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        print();
    }

    //递归实现反转链表
    public void verseRecursive(ListNode p){

        if(p == null)
            return;

        verseRecursive(p.next);

        if(p.next == null){
            head = p;
            q = p;
        }

        p.next = null;
        q.next = p;
        q = q.next;
    }


    //栈实现 时间复杂度:O(n) 空间复杂度:O(n)
    public void versePrint1(){
        Stack<Integer> stack = new Stack<Integer>();

        ListNode p = head;
        if(p == null){
            System.out.println("链表为空");
            return;
        }

        while (p != null){
            stack.push(p.data);
            p = p.next;
        }

        while (!stack.empty()){
            System.out.print(stack.pop()+"-->");
        }
    }

    //递归实现
    public void versePrint2(ListNode p){
        if(p == null){
            return;
        }
        versePrint2(p.next);
        System.out.print(p.data+"-->");
    }


    public static void main(String[] args){
        VerseLinkPrint link = new VerseLinkPrint();
        link.add(1);
        link.add(2);
        link.add(3);
        link.verseRecursive(link.head);
        link.print();
    }
}
