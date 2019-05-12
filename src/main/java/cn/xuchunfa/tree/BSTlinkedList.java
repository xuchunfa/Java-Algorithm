package cn.xuchunfa.tree;

/**
 * @description: 二叉搜索树与双向链表
 * @author: Xu chunfa
 * @create: 2018-09-06 15:29
 **/
public class BSTlinkedList {

    public BinaryTreeNode bstLinkedList(BinaryTreeNode pRoot){

        BinaryTreeNode lastVisited = null;

        reverse(pRoot,lastVisited);

        while (lastVisited != null && lastVisited.left != null){
            lastVisited = lastVisited.left;
        }

        return lastVisited;
    }


    public void reverse(BinaryTreeNode pRoot,BinaryTreeNode lastVisited){

        if(pRoot == null)
            return;

        if(pRoot.left != null)
            reverse(pRoot.left,lastVisited);

        //中序遍历中这段用于处理根节点
        pRoot.left = lastVisited;
        if(lastVisited != null)
            lastVisited.right = pRoot;

        lastVisited = pRoot;
        //

        if(pRoot.right != null)
            reverse(pRoot.right,lastVisited);
    }
}
