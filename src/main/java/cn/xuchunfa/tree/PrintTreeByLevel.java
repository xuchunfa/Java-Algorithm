package cn.xuchunfa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 分层打印二叉树
 * @author: Xu chunfa
 * @create: 2018-09-04 09:09
 **/
public class PrintTreeByLevel {


    public void printTreeByLevel(BinaryTreeNode pRoot, Queue<BinaryTreeNode> queue){


    }

    //"之"型打印树结点 一个栈和一个队列实现
    public void printTreeByLevelZhi(BinaryTreeNode pRoot, Queue<BinaryTreeNode> queue){

        BinaryTreeNode node;

        if(pRoot == null || queue == null)
            return;

        if(pRoot != null){
            queue.offer(pRoot);

            //一层需要打印的结点数目初始化为1
            int toBePrinted = 1;

            //下一行结点的数目
            int nextLevel = 0;

            int currentLevel = 1;

            //队列不为空时出队
            while (!queue.isEmpty()){
                node = queue.poll();//第一个结点出队

                //子树不为空，子树结点则入队
                if(node.left != null) {
                    queue.offer(node.left);
                    nextLevel++;
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    nextLevel++;
                }

                toBePrinted--;

                //根结点的情况
                if(currentLevel == 1){
                    System.out.println(node.data);
                    currentLevel++;
                }

                if(toBePrinted == 0){
                    if((currentLevel & 1) == 0){//偶数层
                        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

                        for(BinaryTreeNode bt : queue){
                            stack.push(bt);
                        }

                        //打印并清空栈
                        while (!stack.isEmpty()){
                            System.out.print(stack.pop().data + " ");
                        }
                    }else {
                        //不能改变原队列中的元素
                        for (BinaryTreeNode bt : queue) {
                            System.out.print(bt.data + " ");
                        }
                    }
                    System.out.println();
                    toBePrinted = nextLevel;
                    currentLevel++;

                    //跳到下一行后从0开始计算nextLevel
                    nextLevel = 0;
                }
            }
        }
    }

    //"之"型打印树结点 两个栈实现
    public void printTreeByLevelZhi1(BinaryTreeNode pRoot, Queue<BinaryTreeNode> queue){

        BinaryTreeNode node;

        if(pRoot == null || queue == null)
            return;

        Stack<BinaryTreeNode> oddStack = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> evenStack = new Stack<BinaryTreeNode>();
        int current = 1;
        if(pRoot != null){

            oddStack.push(pRoot);

            //队列不为空时出栈
            while (!oddStack.isEmpty() || !evenStack.isEmpty()){

                if(current == 1){
                    node = oddStack.pop();
                }else
                    node = evenStack.pop();

                System.out.print(node.data + " ");

                if(current == 1){//代表在奇数层，从左到右打印
                    if(node.left != null){
                        evenStack.push(node.left);
                    }

                    if(node.right != null){
                        evenStack.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        oddStack.push(node.right);
                    }

                    if(node.left != null){
                        oddStack.push(node.left);
                    }
                }

                //当前栈如果为空的话 错误写法：if(oddStack.isEmpty() || evenStack.isEmpty())
                if(current == 1 && oddStack.isEmpty() || current == 0 && evenStack.isEmpty()){
                    System.out.println();
                    current = 1 - current;
                }
            }
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        PrintTreeByLevel test = new PrintTreeByLevel();

        /*tree.createBinaryTree(tree.getRoot(),1);
        tree.createBinaryTree(tree.getRoot(),2);
        tree.createBinaryTree(tree.getRoot(),3);
        tree.createBinaryTree(tree.getRoot(),4);
        tree.createBinaryTree(tree.getRoot(),5);*/
        tree.createBinaryTree(tree.getRoot(),7);
        tree.createBinaryTree(tree.getRoot(),4);
        tree.createBinaryTree(tree.getRoot(),3);
        tree.createBinaryTree(tree.getRoot(),6);
        tree.createBinaryTree(tree.getRoot(),5);
        tree.createBinaryTree(tree.getRoot(),10);
        tree.createBinaryTree(tree.getRoot(),8);

        test.printTreeByLevelZhi1(tree.getRoot(),queue);
    }

}
