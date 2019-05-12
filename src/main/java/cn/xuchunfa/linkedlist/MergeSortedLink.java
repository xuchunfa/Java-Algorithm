package cn.xuchunfa.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 合并两个递增的链表
 * @author: Xu chunfa
 * @create: 2018-08-17 15:37
 **/
public class MergeSortedLink {

    //递归
    public static ListNode merge(ListNode head1,ListNode head2){

        ListNode mergedHead;

        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        if(head1.data < head2.data){
            mergedHead = head1;
            mergedHead.next = merge(head1.next,head2);
        }else if(head1.data > head2.data) {
            mergedHead = head2;
            mergedHead.next = merge(head1,head2.next);
        }else {//相等去重
            mergedHead = head2;
            mergedHead.next = merge(head1.next,head2.next);
        }

        return mergedHead;
    }

    //非递归
    public static ListNode merge1(ListNode head1,ListNode head2){
        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        while (true){
            if(head1 == null){
                tail.next = head2;
                break;
            }

            if(head2 == null){
                tail.next = head1;
                break;
            }

            if(head1.data <= head2.data){
                tail.next = head1;
                head1 = head1.next;
            }else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return temp.next;
    }

    //合并k个有序链表
    public static ListNode mergeK(ListNode[] listNodes,int last){
        while (last != 0){
            int i = 0;
            int j = last;
            while (i < j){
                listNodes[i] = merge1(listNodes[i],listNodes[j]);
                i++;
                j--;
                if(i >= j){
                    last = j;
                }
            }
        }
        return listNodes[0];
    }

    //合并k个有序链表,优先队列实现
    public static ListNode mergeK1(ListNode[] listNodes,int last){

        ListNode head = null;
        ListNode tail = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b)
            {
                return a.data-b.data;
            }
        });

        for (int i = 0; i <= last; i++)
            pq.add(listNodes[i]);

        while (!pq.isEmpty())
        {
            ListNode top = pq.peek();
            pq.remove();

            if (top.next != null)
                pq.add(top.next);

            if (head == null)
            {
                head = top;
                tail = top;
            }
            else
            {
                tail.next = top;
                tail = top;
            }
        }
        // head node of the required merged list
        return head;
    }
    public static void main(String[] args){
        Link link1 = new Link();
        Link link2 = new Link();
        Link link3 = new Link();
        link1.add(1);
        link1.add(2);
        link1.add(3);
        link1.add(5);

        link2.add(2);
        link2.add(4);
        link2.add(6);
        link2.add(7);

        link3.add(2);
        link3.add(4);
        link3.add(6);
        link3.add(8);
        link3.add(10);

        ListNode[] listNodes = {link1.head,link2.head,link3.head};
        ListNode newHead = MergeSortedLink.mergeK1(listNodes,2);


        //ListNode newHead = MergeSortedLink.merge(link1.head,link2.head);
        Link linkHead = new Link();
        linkHead.head = newHead;
        linkHead.print();
    }

}
