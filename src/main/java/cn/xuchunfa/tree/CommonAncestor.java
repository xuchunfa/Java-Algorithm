package cn.xuchunfa.tree;

import cn.xuchunfa.sort.QuickSort;

import java.util.*;

/**
 * @description: 两个结点的最近公共祖先(一个节点可以是它自己的祖先)
 * @author: Xu chunfa
 * @create: 2018-09-03 10:49
 **/
public class CommonAncestor {

    private static boolean v1;
    private static boolean v2;


    //树为二叉搜索树的情况，默认node1 node2已经存在树中
    public BinaryTreeNode BSTfindCommonAncestor(BinaryTreeNode pRoot,int node1,int node2){

        if(pRoot.data > node1 && pRoot.data < node2 || pRoot.data < node1 && pRoot.data > node2)
            return pRoot;

        if(node1 < pRoot.data && node2 < pRoot.data){
            return BSTfindCommonAncestor(pRoot.left,node1,node2);
        }else if(node1 > pRoot.data && node2 > pRoot.data){
            return BSTfindCommonAncestor(pRoot.right,node1,node2);
        }
        
        return null;
    }

    //迭代
    public BinaryTreeNode IterativeBSTfindCommonAncestor(BinaryTreeNode pRoot,int node1,int node2){
        while (pRoot != null){
            if(pRoot.data > node1 && pRoot.data > node2){
                pRoot = pRoot.left;
            }else if(pRoot.data < node1 && pRoot.data < node2) {
                pRoot = pRoot.right;
            }else {
                break;
            }
        }
        return pRoot;
    }

    public BinaryTreeNode BSTfindCommonAncestor1(BinaryTreeNode pRoot,int node1,int node2){

        if(pRoot.data >= node1 && pRoot.data <= node2 || pRoot.data <= node1 && pRoot.data >= node2)
            return pRoot;
        return BSTfindCommonAncestor1(pRoot.left,node1,node2) != null?BSTfindCommonAncestor1(pRoot.left,node1,node2):BSTfindCommonAncestor1(pRoot.right,node1,node2);

    }

    //另一种递归解法
    public BinaryTreeNode findCommonAncestor3(BinaryTreeNode pRoot,int node1,int node2){
        if(pRoot == null)
            return null;
        BinaryTreeNode temp = null;
        if(pRoot.data == node1) {
            v1 = true;
            temp = pRoot;//不直接return
        }
        if(pRoot.data == node2){
            v2 = true;
            temp = pRoot;
        }

        BinaryTreeNode leftTargetNode = findCommonAncestor3(pRoot.left,node1,node2);
        BinaryTreeNode rightTargetNode = findCommonAncestor3(pRoot.right,node1,node2);

        if(temp != null){
            return temp;
        }

        if(leftTargetNode!=null && rightTargetNode!=null){
            return pRoot;
        }
        return leftTargetNode != null?leftTargetNode:rightTargetNode;
    }

    public BinaryTreeNode findAncestor(BinaryTreeNode p,int node1,int node2){
        v1  = false;
        v2  = false;
        BinaryTreeNode ancestor = findCommonAncestor3(p,node1,node2);
        //if((v1 && v2) || v1 && pathIsExisted(p,node2) || v2 && pathIsExisted(p,node1)){
        //    return ancestor;
        //}
        //优化
        if(v1 && v2){
            return ancestor;
        }
        return null;
    }

    //判断路径中是否存在指定结点的值
    public boolean pathIsExisted(BinaryTreeNode pRoot,int node){

        if(pRoot == null)
            return false;

        if(pRoot.data == node)
            return true;

        boolean flag = pathIsExisted(pRoot.left,node);

        //如果找到了就不用继续递归了
        if(!flag){
            flag = pathIsExisted(pRoot.right,node);
        }

        return flag;
    }

    //树为普通二叉树非递归解法
    public BinaryTreeNode findCommonAncestor2(BinaryTreeNode pRoot,int node1,int node2){

        //list1和list2保存根节点到目标结点的路径
        List<BinaryTreeNode> list1 = new ArrayList<BinaryTreeNode>();
        boolean path1 = findPath(pRoot,node1,list1);

        List<BinaryTreeNode> list2 = new ArrayList<BinaryTreeNode>();
        boolean path2 = findPath(pRoot,node2,list2);

        BinaryTreeNode ancestor = null;
        if(!path1 || !path2){//某个节点不存在
            return null;
        }

        int i = 0;
        //找到两条路径岔开的那个位置结点，那么前一个结点就是最后一个公共路径上的结点，也就是最近的祖先
        for(;i < list1.size() && i < list2.size();i++){
            if(list1.get(i) != list2.get(i)){
                break;
            }
        }
        return list1.get(i-1);
    }

    //保存包含指定节点路径结点的方法
    public boolean findPath(BinaryTreeNode pRoot, int node, List<BinaryTreeNode> list){
        if(pRoot ==  null)
            return false;

        list.add(pRoot);

        if(pRoot.data == node)
            return true;

        boolean isExisted = findPath(pRoot.left,node,list);

        if(!isExisted){
            isExisted = findPath(pRoot.right,node,list);
        }

        //左右节点都没找到删掉该元素
        if(!isExisted)
            list.remove(list.size()-1);

        return isExisted;
    }

    
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree(tree.getRoot(),8);
        tree.createBinaryTree(tree.getRoot(),3);
        tree.createBinaryTree(tree.getRoot(),2);
        tree.createBinaryTree(tree.getRoot(),5);
        tree.createBinaryTree(tree.getRoot(),1);
        tree.createBinaryTree(tree.getRoot(),12);
        tree.createBinaryTree(tree.getRoot(),9);

        CommonAncestor test = new CommonAncestor();

        System.out.println(test.BSTfindCommonAncestor1(tree.getRoot(),1,2).data);
    }
}
