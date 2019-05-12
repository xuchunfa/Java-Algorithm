package cn.xuchunfa.tree;

/**
 * @description: 二叉搜索树的后序遍历
 * @author: Xu chunfa
 * @create: 2018-09-04 16:58
 **/
public class PostSequence {

    public static boolean postSequence(int[] num,int start,int end){

        if(start == end)
            return true;

        //start > end 针对1,2,3
        //end < 0 针对3,2,1
        if(end < 0 || start > end){
            return true;
        }



        int root = num[end];

        //找到左右子树的分界点
        int i = start;
        for(;i < end;i++){
            if(num[i] > root)
                break;
        }

        //二叉搜索树i结点右边的值必须都大于root
        int j = i;
        for(;j < end;j++){
            if(num[j] < root)
                return false;
        }

        boolean left = postSequence(num,start,i-1);
        boolean right = postSequence(num,i,end-1);

        return left && right;
    }

    public static void main(String[] args){
        int[] num = {5,7,6,9,12,10,8,14};
        System.out.println(PostSequence.postSequence(num,0,num.length-1));
    }

}
