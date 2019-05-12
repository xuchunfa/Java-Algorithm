package cn.xuchunfa.tree;

/**
 * @description: 判断是否是二叉平衡树？
 * @author: Xu chunfa
 * @create: 2019-04-29 19:57
 **/
public class IsAVLTree {

    public boolean IsBalanced_Solution(BinaryTreeNode root) {
        return calDepth(root) != -1;
    }

    public int calDepth(BinaryTreeNode root){
        if(root == null)
            return 0;
        int leftLen = calDepth(root.left);
        if(leftLen == -1)
            return -1;
        int rightLen = calDepth(root.right);
        if(rightLen == -1)
            return -1;
        return Math.abs(leftLen - rightLen) > 1 ? -1 : Math.max(leftLen,rightLen) + 1;
    }
}
