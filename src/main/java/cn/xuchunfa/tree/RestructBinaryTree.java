package cn.xuchunfa.tree;

/**
 * @description: 创建二叉树
 * @author: Xu chunfa
 * @create: 2018-07-24 11:10
 **/
public class RestructBinaryTree {

    private BinaryTreeNode root;

    //根据前序和中序构造二叉树
    public BinaryTreeNode preAndIn(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){

        if(pre == null || in == null || pre.length <= 0 || in.length <= 0){
            throw new RuntimeException("序列数组长度需大于0");
        }

        if(preEnd < preStart || inEnd < inStart){
            return null;
        }

        //第一个结点
        BinaryTreeNode node = new BinaryTreeNode(pre[preStart]);

        int i = 0;
        for(;i<in.length;i++){
            if(node.data == in[i]){
                node.left = preAndIn(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                node.right = preAndIn(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
                break;
            }
        }

        if(i == in.length){
            throw new RuntimeException("两组序列不匹配");
        }

        return node;
    }

    //根据中序和后序构造二叉树
    public BinaryTreeNode inAndPost(int[] post,int postStart,int postEnd,int[] in,int inStart,int inEnd){

        if(post == null || in == null || post.length <= 0 || in.length <= 0){
            throw new RuntimeException("序列数组长度需大于0");
        }

        if(postEnd < postStart || inEnd < inStart){
            return null;
        }

        //第一个结点
        BinaryTreeNode node = new BinaryTreeNode(post[postEnd]);
        int i = 0;
        for(;i<in.length;i++){
            if(node.data == in[i]){
                node.right = inAndPost(post,postEnd-inEnd+i,postEnd-1,in,i+1,inEnd);
                node.left = inAndPost(post,postStart,postEnd-inEnd+i-1,in,inStart,i-1);
                break;
            }
        }

        if(i == in.length){
            throw new RuntimeException("两组序列不匹配");
        }

        return node;
    }

    //先序遍历,递归实现
    public void preOrder(BinaryTreeNode node){
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    //后序遍历
    public void postOrder(BinaryTreeNode node) {

        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");

    }

    public static void main(String[] args){

        RestructBinaryTree tree = new RestructBinaryTree();
        int[] pre = {1,2,3,4};
        int[] in = {4,3,2,1};
        int[] post = {7,4,2,5,8,6,3,1};

        //tree.root = tree.inAndPost(post,0,post.length-1,in,0,in.length-1);
        tree.root = tree.preAndIn(pre,0,pre.length-1,in,0,in.length-1);
        //tree.preOrder(tree.root);
        tree.postOrder(tree.root);

     }
}
