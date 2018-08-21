package cn.xuchunfa.linkedlist;

/**
 * @description: 链表中环的入口结点
 * @author: Xu chunfa
 * @create: 2018-08-16 14:16
 **/
public class EnterCycleNode {

    public static ListNode meetNode(ListNode head){

        if(head == null){
            throw new RuntimeException("链表不能为空");
        }

        ListNode pre,post;
        pre = head;
        post = head;
        int cycleNodeNum = calcycleNodeNum(head);
        if(cycleNodeNum != 0){//有环
            for(int i = 0;i<cycleNodeNum;i++){//post先走cycleNodeNum步
                pre = pre.next;
            }

            while(post != pre){//然后两个指针依次先前走一步
                pre = pre.next;
                post = post.next;
            }
            return post;
        }

        return null;
    }

    //判断链表是否有环,有的话计算环中一共有多少结点
    private static int calcycleNodeNum(ListNode head) {
        ListNode p,pre;
        p = head;
        pre = head;
        int numOfCycleNode = 0;

        while (pre.next != null){
            pre = pre.next;//走第一步时判断一下
            if (pre != p && pre.next != null){
                p = p.next;
                pre = pre.next;//pre先走了两步
            }

            //走完第二步再判断一下
            if(pre == p){//第一个指针追上了第二个指针
                numOfCycleNode++;
                pre = pre.next;
                while (pre != p){//计算环内结点
                    numOfCycleNode++;
                    pre = pre.next;
                }
                break;//跳出循环
            }
        }
        return numOfCycleNode;
    }

    public static void main(String[] args){
        Link link = new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        ListNode tail = link.head;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = link.head;
        if(EnterCycleNode.meetNode(link.head) != null){
            System.out.println(EnterCycleNode.meetNode(link.head).data);
        }else {
            throw new RuntimeException("不存在环入口节点");
        }

    }

}
