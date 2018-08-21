package cn.xuchunfa.linkedlist;

/**
 * @description: 就地反转链表
 * @author: Xu chunfa
 * @create: 2018-08-16 15:55
 **/
public class VerseLink {

    //直接遍历一遍
    public static void verseLink(ListNode head){
        ListNode previous,current,post;
        previous = null;
        current = head;

        while (current != null){
            post = current.next;

            if(post == null)
                head = current;

            current.next = previous;
            previous = current;
            current = post;
        }
    }

    //递归反转
    public static ListNode recursiveVerseLink(ListNode head){
        if(head  == null || head.next == null){
            return head;
        }

        ListNode newHead = recursiveVerseLink(head.next);//原链表的最后一个结点
        head.next.next = head;//从倒数第二个结点开始回溯,指针发生转向
        head.next = null;//断开原来指针

        return newHead;
    }

    public static void main(String[] args){
        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.head = VerseLink.recursiveVerseLink(link.head);
        link.print();
    }
}
