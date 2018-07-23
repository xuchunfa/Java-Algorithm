package cn.xuchunfa.tree;

import java.util.Random;
import java.util.Stack;

/**
 * @description: 构建二叉树
 * @author: Xu chunfa
 * @create: 2018-07-23 09:27
 **/
public class BinaryTree {

    private BinaryTreeNode root;

    public boolean isEmpty(){
        if(this.root == null)
            return true;

        return false;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void createBinaryTree(BinaryTreeNode node, int data){
        if(root == null){
            this.root = new BinaryTreeNode(data);
        }else{

            //创建二叉查找树
            if(data < node.data){
                //构建左子树
                if(node.left == null){
                    node.left = new BinaryTreeNode(data);
                }else {
                    createBinaryTree(node.left,data);
                }
            }else {
                //构建右子树
                if(node.right == null){
                    node.right = new BinaryTreeNode(data);
                }else {
                    createBinaryTree(node.right,data);
                }
            }
        }

    }

    //先序遍历,递归实现
    public void preOrder(BinaryTreeNode node){
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //先序遍历,非递归实现
    public void cyclePreOrder(BinaryTreeNode node){

        BinaryTreeNode p = node;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        if(p == null){
            System.out.println("二叉树为空");
        }

        //根节点出栈后栈空了但 p != null
        while (p != null || !stack.isEmpty()){
            while (p != null){
                System.out.print(p.data + " ");
                stack.push(p);
                p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.right;
            }
        }

    }

    //中序遍历,递归实现
    public void inOrder(BinaryTreeNode node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //中序遍历,非递归实现
    public void cycleInOrder(BinaryTreeNode node){
        BinaryTreeNode p = node;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        if(p == null){
            System.out.println("二叉树为空");
        }

        //根节点出栈后栈空了但 p != null
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop();
                System.out.print(p.data + " ");
                p = p.right;
            }
        }
    }

    //后序遍历,递归实现
    public void postOrder(BinaryTreeNode node) {

        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");

    }

    //后序遍历,非递归实现
    public void cyclePostOrder(BinaryTreeNode node){
        BinaryTreeNode current;
        BinaryTreeNode visited = null;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();

        s.push(node);

        while (!s.isEmpty()){

            //还不能出栈
            current = s.peek();
            if((current.left == null && current.right == null) || (visited != null && (current.left == visited || current.right == visited)) ){
                current = s.pop();
                System.out.print(current.data + " ");
                visited = current;
            }else {
                if(current.right != null){
                    s.push(current.right);
                }

                if(current.left != null){
                    s.push(current.left);
                }
            }
        }
    }


    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Random random = new Random();

        //10个结点
        for(int i = 0;i<6;i++){
            bt.createBinaryTree(bt.root,random.nextInt(10));
        }
        /*bt.createBinaryTree(bt.root,3);
        bt.createBinaryTree(bt.root,7);
        bt.createBinaryTree(bt.root,9);
        bt.createBinaryTree(bt.root,5);
        bt.createBinaryTree(bt.root,4);
        bt.createBinaryTree(bt.root,2);*/

        bt.postOrder(bt.root);
        System.out.println();
        bt.cyclePostOrder(bt.root);

        //bt.inOrder(bt.root);
        //System.out.println();
        //bt.postOrder(bt.root);

    }

}
