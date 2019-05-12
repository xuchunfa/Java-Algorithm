package cn.xuchunfa.tree;

import java.util.HashMap;

/**
 * @description: 创建二叉树
 * @author: Xu chunfa
 * @create: 2018-07-24 11:10
 **/
public class RestructBinaryTree {

    private BinaryTreeNode root;

    static int preIndex;

    static int postIndex;

    public int search(int[] in,int start,int end,int data){
        int i;
        for(i = start;i < end;i++){
            if(in[i] == data)
                return i;
        }
        return i;
    }

    public BinaryTreeNode createPreAndInTree(int[] pre,int[] in,int inStart,int inEnd,HashMap<Integer,Integer> indexHash){
        if(inStart > inEnd)
            return null;
        int value = pre[preIndex++];
        BinaryTreeNode node = new BinaryTreeNode(value);
        if(inStart == inEnd)
            return node;

        //int inIndex = search(in,inStart,inEnd,node.data);
        //node.left = createTree(pre,in,inStart,inIndex-1);
        //node.right = createTree(pre,in,inIndex+1,inEnd);
        int inIndex = indexHash.get(value);
        node.left = createPreAndInTree(pre,in,inStart,inIndex-1,indexHash);
        node.right = createPreAndInTree(pre,in,inIndex+1,inEnd,indexHash);
        return node;
    }

    public BinaryTreeNode reConstructBinaryTree(int [] pre,int [] in) {
        preIndex = 0;
        HashMap<Integer,Integer> inorderHash = new HashMap<>();
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        for(int i = 0;i < in.length;i++){
            inorderHash.put(in[i],i);
        }
        return createPreAndInTree(pre,in,0,in.length-1,inorderHash);
    }

    ////根据前序和中序构造二叉树
    //public BinaryTreeNode preAndIn(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
    //
    //    if(pre == null || in == null || pre.length <= 0 || in.length <= 0){
    //        throw new RuntimeException("序列数组长度需大于0");
    //}
    //
    //    if(preEnd < preStart || inEnd < inStart){
    //        return null;
    //    }
    //
    //    //第一个结点
    //    BinaryTreeNode node = new BinaryTreeNode(pre[preStart]);
    //
    //    int i = 0;
    //    for(;i<in.length;i++){
    //        if(node.data == in[i]){
    //            node.left = preAndIn(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
    //            node.right = preAndIn(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
    //            break;
    //        }
    //    }
    //
    //    if(i == in.length){
    //        throw new RuntimeException("两组序列不匹配");
    //    }
    //
    //    return node;
    //}

    public BinaryTreeNode createInAndPostTree(int[] post,int[] in,int inStart,int inEnd,HashMap<Integer,Integer> indexHash){
        if(inStart > inEnd)
            return null;
        int value = post[postIndex--];
        BinaryTreeNode node = new BinaryTreeNode(value);
        if(inStart == inEnd)
            return node;

        int inIndex = indexHash.get(value);
        node.right = createInAndPostTree(post,in,inIndex+1,inEnd,indexHash);
        node.left = createInAndPostTree(post,in,inStart,inIndex-1,indexHash);
        return node;
    }

    public BinaryTreeNode inAndPostRestruct(int[] post,int[] in){
        HashMap<Integer,Integer> inorderHash = new HashMap<>();
        if(in.length == 0 || post.length == 0){
            return null;
        }
        postIndex = post.length - 1;
        for(int i = 0;i < in.length;i++){
            inorderHash.put(in[i],i);
        }
        return createInAndPostTree(post,in,0,in.length-1,inorderHash);
    }

    //根据中序和后序构造二叉树
    //public BinaryTreeNode inAndPost(int[] post,int postStart,int postEnd,int[] in,int inStart,int inEnd){
    //
    //    if(post == null || in == null || post.length <= 0 || in.length <= 0){
    //        throw new RuntimeException("序列数组长度需大于0");
    //    }
    //
    //    if(postEnd < postStart || inEnd < inStart){
    //        return null;
    //    }
    //
    //    //第一个结点
    //    BinaryTreeNode node = new BinaryTreeNode(post[postEnd]);
    //    int i = 0;
    //    for(;i<in.length;i++){
    //        if(node.data == in[i]){
    //            node.right = inAndPost(post,postEnd-inEnd+i,postEnd-1,in,i+1,inEnd);
    //            node.left = inAndPost(post,postStart,postEnd-inEnd+i-1,in,inStart,i-1);
    //            break;
    //        }
    //    }
    //
    //    if(i == in.length){
    //        throw new RuntimeException("两组序列不匹配");
    //    }
    //
    //    return node;
    //}

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
        //int[] pre = {1,2,4,7,3,5,6,8};
        //int[] in = {4,7,2,1,5,3,8,6};
        int[] in = {4,8,2,5,1,6,3,7};
        int[] post = {8,4,5,2,6,7,3,1};

        tree.root = tree.inAndPostRestruct(post,in);

        //tree.root = tree.inAndPost(post,0,post.length-1,in,0,in.length-1);
        //tree.root = tree.preAndIn(pre,0,pre.length-1,in,0,in.length-1);
        //tree.preOrder(tree.root);
        tree.preOrder(tree.root);

     }
}
