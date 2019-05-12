package cn.xuchunfa.linkedlist;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.List;

/**
 * @description: 求链表中的倒数第 k 个节点
 * @author: Xu chunfa
 * @create: 2018-07-17 09:05
 **/
public class Link {

    ListNode head;

    //添加链表节点
    public void add(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else {
            this.head.addNode(node);
        }
    }

    //打印链表节点
    public void print(){
        if(this.head == null){
            System.out.println("链表为空");
        }else {
            this.head.printNode();
            System.out.println();
        }
    }


    //链表中的倒数第 K 个结点
    public ListNode FindKthToTail(ListNode head,int k){

        ListNode fast = head;
        ListNode slow = head;

        if(k <= 0){
            throw new RuntimeException("请输入自然数k！");
        }

        if(head == null) {
            throw new RuntimeException("链表不能为空！");
        }
        int i = 0;
        while (i < k){
            if(fast != null){
                fast = fast.next;
            }else {
                throw new RuntimeException("k值大于了链表长度");
            }
            i++;
        }
        //for(int i = 0;i < k;i++){
        //    if(fast != null){//先走k步
        //        fast = fast.next;
        //    }else {
        //        throw new RuntimeException("k值大于了链表长度");
        //    }
        //}

        while (fast != null){//pre == null 时p指针指向倒数第k个结点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){

        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.print();

        ListNode node = link.FindKthToTail(link.head,2);
        node.next = null;
        node.printNode();

    }
}
