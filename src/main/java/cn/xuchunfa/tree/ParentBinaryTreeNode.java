package cn.xuchunfa.tree;

/**
 * @description: 带父指针的树结点
 * @author: Xu chunfa
 * @create: 2018-07-24 19:31
 **/
public class ParentBinaryTreeNode {

    int data;
    ParentBinaryTreeNode left;
    ParentBinaryTreeNode right;
    ParentBinaryTreeNode parent;

    public ParentBinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
