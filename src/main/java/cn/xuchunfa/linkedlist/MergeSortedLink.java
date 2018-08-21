package cn.xuchunfa.linkedlist;

/**
 * @description: 合并两个递增的链表
 * @author: Xu chunfa
 * @create: 2018-08-17 15:37
 **/
public class MergeSortedLink {

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
        }else {
            mergedHead = head2;
            mergedHead.next = merge(head1,head2.next);
        }

        return mergedHead;
    }

    public static void main(String[] args){
        Link link1 = new Link();
        Link link2 = new Link();
        link1.add(1);
        link1.add(3);
        link1.add(5);

        link2.add(2);
        link2.add(4);
        link2.add(6);
        link2.add(7);

        ListNode newHead = MergeSortedLink.merge(link1.head,link2.head);
        Link link3 = new Link();
        link3.head = newHead;
        link3.print();
    }

}
