package cn.xuchunfa.tree;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-07-24 19:36
 **/
public class ParentBinaryTree {

    ParentBinaryTreeNode root;

    public void createTree(ParentBinaryTreeNode node,int data){

        if(this.root == null){
            root = new ParentBinaryTreeNode(data);
        }else {
            //二叉查找树
            if(data < node.data){
                if(node.left == null){
                    ParentBinaryTreeNode temp = new ParentBinaryTreeNode(data);
                    node.left = temp;
                    temp.parent = node;
                }else {
                    createTree(node.left,data);
                }
            }else {
                if(node.right == null){
                    ParentBinaryTreeNode temp = new ParentBinaryTreeNode(data);
                    node.right = temp;
                    temp.parent = node;
                }else {
                    createTree(node.right,data);
                }
            }
        }
    }

    //中序遍历,递归实现
    public void inOrder(ParentBinaryTreeNode node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //找出中序遍历中的下一个点
    public ParentBinaryTreeNode searchNext(ParentBinaryTreeNode node,int data){

        if(node == null){
            throw new RuntimeException("空树");
        }

        ParentBinaryTreeNode dataNode = searchData(node,data);

        ParentBinaryTreeNode next = null;

        if(dataNode == null){
            throw new RuntimeException("不存在该值");
        }else{
            //有右子树
            if(dataNode.right != null){
                ParentBinaryTreeNode temp = dataNode.right;
                while (temp.left != null){
                    temp = temp.left;
                }
                next = temp;
            }else if(dataNode.parent != null){//等于null说明是根节点
                ParentBinaryTreeNode current =  dataNode;
                ParentBinaryTreeNode parent = current.parent;
                while (parent != null && parent.right == current){
                    current = parent;
                    parent = parent.parent;
                }
                next = parent;//parent有可能为null
            }
        }
        return next;
    }

    private ParentBinaryTreeNode searchData(ParentBinaryTreeNode node, int data) {

        if(node == null){
           return null;
        }

        if(node.data == data){
            return node;
        }else if(searchData(node.left,data) != null){
            return searchData(node.left,data);
        }else
            return searchData(node.right,data);
    }

    public static void main(String[] args){

        ParentBinaryTree tree = new ParentBinaryTree();

        //for(int i = 2;i<10;i++){
        //    tree.createTree(tree.root,i);
        //}

        tree.createTree(tree.root,9);
        tree.createTree(tree.root,5);
        tree.createTree(tree.root,3);
        tree.createTree(tree.root,7);
        tree.createTree(tree.root,6);
        tree.createTree(tree.root,8);
        tree.createTree(tree.root,12);
        tree.createTree(tree.root,10);
        tree.createTree(tree.root,14);

        tree.inOrder(tree.root);
        System.out.println();

        ParentBinaryTreeNode node = tree.searchNext(tree.root,5);
        if(node != null){
            System.out.println(node.data);
        }else {
            System.out.println("最后一个结点");
        }
    }
}
