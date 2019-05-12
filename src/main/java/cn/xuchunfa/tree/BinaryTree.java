package cn.xuchunfa.tree;

import cn.xuchunfa.javapattern.observer.PublicMessage;

import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;
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

    public void iterativePreOrder(BinaryTreeNode p){
        Stack<BinaryTreeNode> stack = new Stack<>();
        if(p != null){
            stack.push(p);
        }
        while (!stack.isEmpty()){
            BinaryTreeNode q = stack.pop();
            System.out.print(q.data + " ");
            if(q.right != null){
                stack.push(q.right);
            }
            if(q.left != null){
                stack.push(q.left);
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

    //后续遍历迭代实现
    public void iterativePostOrder(BinaryTreeNode p){
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        while (true){
            while (p != null){
                s.push(p);
                s.push(p);
                p = p.left;
            }
            if(s.isEmpty())
                return;
            p = s.pop();
            if(!s.isEmpty() && p == s.peek()){
                p = p.right;
            }else {
                System.out.print(p.data + " ");
                p = null;
            }
        }
    }

    //后续遍历的倒序方法
    public void reversePostOrder(BinaryTreeNode p){
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> result = new Stack<>();
        if(p != null){
            s.push(p);
        }
        while (!s.isEmpty()){
            p = s.pop();
            //System.out.print(p.data + " ");
            result.push(p);
            if(p.left != null){
                s.push(p.left);
            }
            if(p.right != null){
                s.push(p.right);
            }
        }

        while (!result.isEmpty()){
            System.out.print(result.pop().data + " ");
        }
    }

    //队列实现层次遍历
    public void levelOrder(BinaryTreeNode p){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(p != null){
            queue.offer(p);
        }
        int level = 0;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0;i < queueSize;i++){//queueSize表示每一层的节点数
                p = queue.poll();
                System.out.print(p.data + " ");
                if(p.left != null){
                    queue.offer(p.left);
                }
                if (p.right != null){
                    queue.offer(p.right);
                }
            }
            level++;
            System.out.println();
        }
        System.out.println("The max deepth of tree is: " + level);
    }

    //S型层次遍历
    public void levelSOrder(BinaryTreeNode p){
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        int currentLevel = 1;
        if(p != null){
            stack1.push(p);
        }

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int levelNumber = !stack1.isEmpty()?stack1.size():stack2.size();
            for(int i = 0;i < levelNumber;i++){
                if((currentLevel & 1) == 1){
                    p = stack1.pop();
                    System.out.print(p.data + " ");
                    if(p.right != null){
                        stack2.push(p.right);
                    }
                    if(p.left != null){
                        stack2.push(p.left);
                    }
                    if(stack1.empty()){
                        currentLevel++;
                    }
                }else {
                    p = stack2.pop();
                    System.out.print(p.data + " ");
                    if(p.left != null){
                        stack1.push(p.left);
                    }
                    if(p.right != null){
                        stack1.push(p.right);
                    }
                    if(stack2.empty()){
                        currentLevel++;
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Random random = new Random();

        //10个结点
        for(int i = 0;i<6;i++){
            bt.createBinaryTree(bt.root,random.nextInt(20));
        }
        /*bt.createBinaryTree(bt.root,3);
        bt.createBinaryTree(bt.root,7);
        bt.createBinaryTree(bt.root,9);
        bt.createBinaryTree(bt.root,5);
        bt.createBinaryTree(bt.root,4);
        bt.createBinaryTree(bt.root,2);*/

        bt.preOrder(bt.root);
        System.out.println();
        bt.inOrder(bt.root);
        System.out.println();
        bt.levelOrder(bt.root);

        //bt.inOrder(bt.root);
        //System.out.println();
        //bt.postOrder(bt.root);

    }

}
