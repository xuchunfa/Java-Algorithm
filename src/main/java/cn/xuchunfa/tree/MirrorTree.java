package cn.xuchunfa.tree;

/**
 * @description: 镜像树
 * @author: Xu chunfa
 * @create: 2018-08-19 14:47
 **/
public class MirrorTree {

    public static void mirror(BinaryTreeNode p){
        if(p == null)
            return;

        //遍历到叶子结点结束
        if(p.left == null && p.right == null){
            return;
        }

        BinaryTreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left != null){
            mirror(p.left);
        }

        if(p.right != null){
            mirror(p.right);
        }
    }

}
