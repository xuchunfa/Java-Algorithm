package cn.xuchunfa.tree;

import org.junit.Test;

/**
 * @description: 判断数组是否是BST的后序遍历
 * @author: Xu chunfa
 * @create: 2019-04-03 15:56
 **/
public class CheckPostOrder {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return verify(sequence,0,sequence.length-1);
    }
    public boolean verify(int[] array,int left,int right){
        if(left >= right)
            return true;
        int i = right;
        while (i >= left && array[i] >= array[right])
            i--;
        for(int j = i;j >= left;j--){
            if(array[j] > array[right])
                return false;
        }

        return verify(array,left,i) && verify(array,i+1,right-1);
    }

    @Test
    public void test(){
        int[] a = {3,6,4,8,12,9,7};
        System.out.println(VerifySquenceOfBST(a));
    }
}
