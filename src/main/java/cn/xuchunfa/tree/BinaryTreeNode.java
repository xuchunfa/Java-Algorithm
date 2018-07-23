package cn.xuchunfa.tree;

/**
 * @description: 二叉树结点
 * @author: Xu chunfa
 * @create: 2018-07-23 09:19
 **/
public class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;


    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    //判断是否是叶子结点
    public boolean isLeaf(BinaryTreeNode node){
        if(node.left == null && node.right == null)
            return true;

        return false;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

}
