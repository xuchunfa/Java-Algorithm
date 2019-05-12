package cn.xuchunfa.tree;

import org.junit.Test;

/**
 * @description: 序列化和反序列化树，空值用#表示
 * @author: Xu chunfa
 * @create: 2019-05-07 15:55
 **/
public class SerializeTree {

    StringBuilder sb = new StringBuilder();
    private int index = -1;

    String Serialize(BinaryTreeNode root) {

        if(root == null){
            sb.append("#");
            return sb.toString();
        }
        sb.append(root.data);
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    BinaryTreeNode Deserialize(String str) {
        ++index;
        if(str.charAt(index) == '#')
            return null;

        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(str.charAt(index) + ""));
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }

    @Test
    public void test(){
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        //node1.left = node2;
        //node1.right = node3;
        //node3.right = node4;

        node1.left = node2;
        node1.right = node3;
        //System.out.println(Serialize(node1));
        System.out.println(Serialize(node1));
        sb = new StringBuilder();
        BinaryTreeNode node = Deserialize(Serialize(node1));
        TreeUtils.preOrder(node);

    }
}
