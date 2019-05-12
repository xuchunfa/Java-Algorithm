package cn.xuchunfa.tree;

import org.junit.Test;

/**
 * @description: 二叉搜索树中第 K小的数
 * @author: Xu chunfa
 * @create: 2019-05-07 20:06
 **/
public class BSTksmallest {

    private int counter = 0;
    public BinaryTreeNode KthNode(BinaryTreeNode pRoot, int k)
    {
        if(pRoot == null)
            return null;

        BinaryTreeNode node = KthNode(pRoot.left,k);
        if(node != null)//剪枝
            return node;
        ++counter;
        if(counter == k)
            return pRoot;
        node = KthNode(pRoot.right,k);
        if(node != null)
            return node;

        return null;
    }

    //第K大的数
    public BinaryTreeNode KBiggestNode(BinaryTreeNode pRoot, int k)
    {
        if(pRoot == null)
            return null;

        //先走右边 右边比左边大
        BinaryTreeNode node = KBiggestNode(pRoot.right,k);
        if(node != null)//剪枝
            return node;
        ++counter;
        if(counter == k)
            return pRoot;
        node = KBiggestNode(pRoot.left,k);
        if(node != null)
            return node;

        return null;
    }

    @Test
    public void test(){
        BinaryTreeNode node1 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;
        node3.left = node6;
        //System.out.println(KthNode(node1,1).data);
        System.out.println(KBiggestNode(node1,3).data);
    }
}
