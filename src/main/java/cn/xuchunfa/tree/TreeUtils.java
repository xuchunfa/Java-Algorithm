package cn.xuchunfa.tree;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-05-07 16:08
 **/
public class TreeUtils {

    public static void preOrder(BinaryTreeNode node){
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
