package cn.xuchunfa.array;

/**
 * @description: 找到数组中重复的数,数组长度为 n,数组元素为 0~n-1
 * @author: Xu chunfa
 * @create: 2018-07-18 15:45
 **/
public class OptDuplication {

    //哈希表的方法解决，时间复杂度：O(n) 空间复杂度：O(n)
    boolean findDup1(int[] nums,int len,int[] duplication){

        if(nums == null || len <= 0){
            System.out.println("数组必须存在且不能为空!");
            return  false;
        }

        for(int i = 0;i<len;i++){
            if(nums[i]<0 || nums[i]>len-1) {
                System.out.println("数组元素应在0 ~ len-1");
                return false;
            }
        }

        //哈希表
        int[] count = new int[len];
        for(int i = 0;i<len;i++){
            if(count[nums[i]] == 1){
                duplication[0] = nums[i];
                return true;
            }

            count[nums[i]]++;
        }

        return false;

    }

    //时间复杂度O(n) 空间复杂度O(1)
    boolean findDup(int[] nums,int len,int[] duplication){

        if(nums == null || len <= 0){
            System.out.println("数组必须存在且不能为空!");
            return  false;
        }

        for(int i = 0;i<len;i++){
            if(nums[i]<0 || nums[i]>len-1) {
                System.out.println("数组元素应在0 ~ len-1");
                return false;
            }
        }

        int temp;
        for(int i = 0;i<len;i++){
            while (i != nums[i]){
                //nums[i]=m 说明 m 所在的下标是 i 和 m 所以重复了
                if(nums[i] == nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }else {
                    //交换num[i] 和 num[num[i]]
                    temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                }
            }
        }

        System.out.println("没有重复数字");
        return false;
    }

    public static void main(String[] args){
        int a[] = {1,0,2};
        int[] result = new int[1];
        boolean b = new OptDuplication().findDup1(a,a.length,result);
        if(b){
            System.out.println(b + " " + result[0]);
        }else {
            System.out.println(b);
        }

    }

}
