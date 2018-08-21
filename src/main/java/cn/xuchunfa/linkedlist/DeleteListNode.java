package cn.xuchunfa.linkedlist;

/**
 * @description: 在 O(1) 时间内删除指定结点
 * @author: Xu chunfa
 * @create: 2018-08-13 12:50
 **/
public class DeleteListNode {

    public static void deleteListNode(Link link,ListNode head,ListNode toDelete){

        if(head == null || toDelete == null){
            throw new RuntimeException("没有目标节点删除");
        }

        //只有一个头节点,删完后置空
        if(head.next == null && toDelete.next == null){
            link.head = null;//head = null 相当于值传递,无法改变head
            toDelete = null;
        }else if(head.next != null && toDelete.next == null){//删除尾结点
            ListNode pre = head;
            while (pre.next != toDelete){
                pre = pre.next;
            }
            pre.next = null;
        }else {//head.next != null && toDelete.next != null 删除中间结点
            toDelete.data = toDelete.next.data;
            toDelete.next = toDelete.next.next;
        }
    }
    
    public static void main(String[] args){
        Link link = new Link();
        link.add(1);

        ListNode toDelete = link.head;
        DeleteListNode.deleteListNode(link,link.head,toDelete);
        link.print();
    }
}
