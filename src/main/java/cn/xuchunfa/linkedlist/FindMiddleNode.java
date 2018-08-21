package cn.xuchunfa.linkedlist;

/**
 * @description: 找到链表的中间结点，只允许遍历链表一次
 * @author: Xu chunfa
 * @create: 2018-08-15 16:02
 **/
public class FindMiddleNode {

    public static ListNode find(ListNode head){
        ListNode pre,p;
        pre = head;
        p = head;

        if(head == null){
            throw new RuntimeException("链表不能为空");
        }

        while (pre.next != null){
            pre = pre.next;
            p = p.next;
            if(pre.next != null)
                pre = pre.next;//指针pre走两步 指针p走一步
        }

        return  p;
    }

    public static void main(String[] args){
        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);
        System.out.println(FindMiddleNode.find(link.head).data);

    }

}
