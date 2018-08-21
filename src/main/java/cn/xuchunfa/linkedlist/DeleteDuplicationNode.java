package cn.xuchunfa.linkedlist;

/**
 * @description: 删除有序链表中的重复结点
 * @author: Xu chunfa
 * @create: 2018-08-13 15:08
 **/
public class DeleteDuplicationNode {

    //例如(1,2,2,2,3) >> (1,2,3)
    public static void deleteDuplicationNode(ListNode head){

        if(head == null){
            throw new RuntimeException("链表不存在");
        }

        //默认是增序的(包含所有结点相等的情况)
        boolean ascend = true;

        ListNode post,p;
        p = head;

        while(p.next != null){
            if(p.data > p.next.data){
                ascend = false;//降序
            }
            p = p.next;
        }

        p = head;

        if(ascend){//链表递增时
            while (p.next != null){
                if(p.data == p.next.data){
                    post = p.next;
                    while(post.next != null){
                        if(post.data < post.next.data){
                            p.next = post.next;
                            break;//结束
                        }
                        post = post.next;
                    }

                    if(post.next == null){
                        p.next = post.next;
                        break;
                    }
                }

                p = p.next;
            }

        }else {//链表递减
            while (p.next != null){
                if(p.data == p.next.data){
                    post = p.next;
                    while(post.next != null){
                        if(post.data > post.next.data){
                            p.next = post.next;
                            break;
                        }
                        post = post.next;
                    }

                    if(post.next == null){
                        p.next = post.next;
                        break;
                    }
                }

                //break跳到这里,继续遍历
                p = p.next;
            }
        }
    }

    //例如(1,2,3,3,4,4,5) >> (1,2,5)
    public static void DeleteDuplication(Link link,ListNode head){

        if(head == null){
            throw new RuntimeException("链表不存在");
        }

        ListNode pre = null;
        ListNode p = head;
        ListNode post;

        while (p != null){

            post = p.next;
            boolean needDeleted = false;
            if(post != null && p.data == post.data){
                needDeleted = true;
            }

            if(!needDeleted){
                pre = p;
                p = p.next;
            }else {
                int value = p.data;
                ListNode toDelete = p;
                while (toDelete != null && toDelete.data == value){
                    post = toDelete.next;
                    toDelete = post;
                }

                if(pre == null){//删除头节点.可能所有结点相等 head = null
                    link.head = post;
                }else {
                    pre.next = post;
                }

                p = post;
            }

        }
    }

    public static void main(String[] args){
        Link link = new Link();
        link.add(1);
        link.add(1);
        link.add(1);
        DeleteDuplicationNode.DeleteDuplication(link,link.head);
        link.print();
    }

}
