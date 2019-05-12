package cn.xuchunfa.linkedlist;

/**
 * @description: 删除有序链表中的重复结点
 * @author: Xu chunfa
 * @create: 2018-08-13 15:08
 **/
public class DeleteDuplicationNode {

    //例如(1,2,2,2,3) >> (1,2,3)
    public static ListNode deleteDuplicationNode(ListNode pHead){
        if(pHead == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode last = pHead;
        ListNode current = pHead;
        while (current != null && current.next != null){
            if(current.data == current.next.data){
                int data = current.data;
                while(current != null && current.data == data){
                    current = current.next;
                }
                last.next = current;
                last = current;//保留重复节点的第一个节点
            }else {
                current = current.next;
                last = current;//保留不重复节点的第二个节点
            }
        }
        return dummy.next;

    }

    //例如(1,2,3,3,4,4,5) >> (1,2,5)
    public static ListNode DeleteDuplication(ListNode pHead){
        if(pHead == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode last = dummy;
        ListNode current = pHead;
        while (current != null && current.next != null){
            if(current.data == current.next.data){
                int data = current.data;
                while(current != null && current.data == data){
                    current = current.next;
                }
                last.next = current;
            }else {
                //保留值不相等的两个连续节点的第一个节点
                last = current;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Link link = new Link();
        link.add(3);
        link.add(3);
        link.add(3);
        link.add(3);
        link.add(3);
        link.add(3);
        //DeleteDuplicationNode.DeleteDuplication(link,link.head);
        ListNode result = DeleteDuplicationNode.deleteDuplicationNode(link.head);
        result.printNode();
    }

}
