package cn.xuchunfa.linkedlist;

import java.util.Scanner;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-08 19:45
 **/
public class Test {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String link = in.nextLine();
        String[] strs = link.split(",");
        System.out.println(strs);
        boolean result = judge(strs);
        //System.out.println(result);

    }

    private static boolean judge(String[] strs) {
        if(strs == null || strs.length == 0){
            return false;
        }


        return true;
    }

    public boolean findEntryNode(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            if(fast == slow){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast){
            return false;
        }

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
