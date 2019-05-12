package cn.xuchunfa.linkedlist;

import java.util.Scanner;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-08 20:21
 **/
public class Test1 {

    public static void main(String[] args) {

        Test1 solution = new Test1();
        Scanner in  = new Scanner(System.in);
        String strs = in.nextLine();
        int k = in.nextInt();
        System.out.println(strs);
        String[] numStrs = strs.substring(0,strs.length()).split(",");
        ListNode listNode = new ListNode(Integer.parseInt(numStrs[0]));
        for(int i = 1;i < numStrs.length;i++){
            ListNode node = new ListNode(Integer.parseInt(numStrs[i]));
            listNode.next = node;
        }

        ListNode headListNode = solution.reverseKGroup(listNode, k);
        while  (headListNode != null){
            System.out.println(headListNode.data);
            headListNode = headListNode.next;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1){
            return head;
        }
        return back(head,k) ;
    }
    public ListNode back(ListNode head, int k){
        int count = 0;
        ListNode cur = head;
        while (count < k && cur != null){
            cur = cur.next;
            count++;
        }
        ListNode temp = head;
        ListNode revNow = null;
        ListNode revHead = null;
        if (count == k){
            for (int i = 0; i < k; i++){
                if (temp!=null){
                    revNow = temp.next;
                    temp.next = revHead;
                    revHead = temp;
                    temp = revNow;
                }
            }
            if (revNow != null){
                head.next = reverseKGroup(revNow, k);
            }
            return revHead;
        }else{
            return head;
        }
    }
}
