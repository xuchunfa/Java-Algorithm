package cn.xuchunfa.linkedlist;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-22 15:07
 **/
public class ListNode {

    public int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void addNode(ListNode newNode){

        //相当于尾插法
        if(this.next == null){
            this.next = newNode;
        }else {
            this.next.addNode(newNode);
        }
    }

    public void printNode(){
        System.out.print(this.data + "-->");
        if(this.next != null){
            this.next.printNode();
        }
    }
}
