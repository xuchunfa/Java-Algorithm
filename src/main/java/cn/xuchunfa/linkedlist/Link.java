package cn.xuchunfa.linkedlist;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.List;

/**
 * @description: 求链表中的倒数第 k 个节点
 * @author: Xu chunfa
 * @create: 2018-07-17 09:05
 **/
public class Link {

    private ListNode head;

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

        int len = 0;
        int i = 0;
        ListNode counter = head;
        ListNode p = head;
        ListNode pre = head;

        if(k <= 0){
            System.out.println("请输入自然数k！");
            //-1代表非正常退出
            System.exit(-1);
        }

        if(head == null) {
            System.out.println("链表不能为空！");
            System.exit(-1);
        }

        while(counter != null){
            len++;
            counter = counter.next;
        }

        if(k > len){
            System.out.println("k值大于了链表长度！");
            System.exit(-1);
        }

        //先走k步
        while (i < k){
            pre = pre.next;
            i++;
        }

        while (pre != null){
            p = p.next;
            pre = pre.next;
        }

        return p;
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
