package cn.xuchunfa.tree;

/**
 * @description: 判断对称树
 * @author: Xu chunfa
 * @create: 2018-08-19 15:45
 **/
public class SymmetricalTree {

    public static boolean isSymmetricalTree(BinaryTreeNode root){
        return isSymmetricalTree(root,root);
    }

    public static boolean isSymmetricalTree(BinaryTreeNode p1,BinaryTreeNode p2){
        if(p1 == null && p2 == null){
            return true;
        }

        //其中有一个为null,另一个不为null
        if(p1 == null || p2 == null){
            return false;
        }

        if(p1.data != p2.data){
            return false;
        }

        //p1:根结点->左子树->右子树 p2:根结点->右子树->左子树
        return isSymmetricalTree(p1.left,p2.right) && isSymmetricalTree(p1.right,p2.left);
    }

}
