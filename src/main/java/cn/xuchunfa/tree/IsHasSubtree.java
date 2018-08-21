package cn.xuchunfa.tree;

/**
 * @description: 判断树的子树
 * @author: Xu chunfa
 * @create: 2018-08-19 13:00
 **/
public class IsHasSubtree {

    public static boolean isSubtree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){

            //相等的话就进行判断
            if(root1.data == root2.data){
                result = judge(root1,root2);
            }

            //不相等的话先序遍历
            /*if(!result){
                result = isSubtree(root1.left,root2);
            }
            if(!result){
                result = isSubtree(root1.right,root2);
            }*/
            if(!result){
                result = isSubtree(root1.left,root2) || isSubtree(root1.right,root2);
            }

        }

        //第一个结点至少有一个为空的情况或者第一个结点的值不相等
        return result;
    }

    private static boolean judge(BinaryTreeNode root1, BinaryTreeNode root2) {

        //子树的左右子树都遍历完成
        if(root2 == null){
            return true;
        }

        //子树还没遍历完,父树就已经遍历完了,两者顺序不能反
        if (root1 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        //先序遍历
        return judge(root1.left,root2.left) && judge(root1.right,root2.right);
    }

    public static void main(String[] args){
        BinaryTree root1 = new BinaryTree();
        root1.createBinaryTree(root1.getRoot(),3);
        root1.createBinaryTree(root1.getRoot(),2);
        root1.createBinaryTree(root1.getRoot(),6);
        root1.createBinaryTree(root1.getRoot(),7);
        root1.createBinaryTree(root1.getRoot(),5);
        root1.createBinaryTree(root1.getRoot(),9);

        BinaryTree root2 = new BinaryTree();
        root2.createBinaryTree(root2.getRoot(),6);
        root2.createBinaryTree(root2.getRoot(),5);
        root2.createBinaryTree(root2.getRoot(),8);

        System.out.println(IsHasSubtree.isSubtree(root1.getRoot(),root2.getRoot()));
    }


}
