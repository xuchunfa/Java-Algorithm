package cn.xuchunfa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 二叉树中和为某一值的路径(从根到叶结点)
 * @author: Xu chunfa
 * @create: 2018-09-06 09:43
 **/
public class SumOfTrace {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root,int target) {
        if(root == null)
            return listAll;

        list.add(root.data);
        target -= root.data;
        if(target >= 0){
            if(target == 0 && root.left == null && root.right == null)
                listAll.add(new ArrayList<Integer>(list));

            FindPath(root.left, target);
            FindPath(root.right, target);

            list.remove(list.size()-1);
        }

        return listAll;
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(tree.getRoot(),10);
        tree.createBinaryTree(tree.getRoot(),7);
        tree.createBinaryTree(tree.getRoot(),3);
        tree.createBinaryTree(tree.getRoot(),8);
        tree.createBinaryTree(tree.getRoot(),2);
        tree.createBinaryTree(tree.getRoot(),5);
        tree.createBinaryTree(tree.getRoot(),12);

        SumOfTrace test = new SumOfTrace();

        System.out.println(test.FindPath(tree.getRoot(),22));
    }
}
