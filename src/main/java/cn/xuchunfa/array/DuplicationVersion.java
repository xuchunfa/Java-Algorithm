package cn.xuchunfa.array;

/**
 * @description: 找到数组中重复的数,数组长度为 n+1,数组元素为 1~n
 * @author: Xu chunfa
 * @create: 2018-07-18 19:32
 **/
public class DuplicationVersion {

    //时间复杂度:O(nlogn) 空间复杂度:O(1)
    boolean findDup(int[] nums,int len,int[] duplication){

        if(nums == null || len <= 0){
            System.out.println("数组必须存在且不能为空!");
            return  false;
        }

        for(int i = 0;i<len;i++){
            if(nums[i]<=0 || nums[i]>len-1) {
                System.out.println("数组元素应在1 ~ "+ (len-1)+ "之间");
                return false;
            }
        }

        int start = 1;
        int end = len-1;
        int middle;
        while(start <=  end){

            middle = (start + end)/2;
            int number = calNum(nums,len,start,middle);

            //结束条件
            if(start == end){
                if(number > 1){
                    duplication[0] = start;
                    return true;
                }else{
                    break;
                }
            }

            if(middle - start + 1 < number){
                end = middle;
            }else {
                start = middle + 1;
            }
        }

        System.out.println("没有重复数字");
        return false;
    }

    private int calNum(int[] nums, int len, int start, int end) {
        int count = 0;
        for(int i = 0;i<len;i++){
            if(nums[i] >= start && nums[i] <= end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int a[] = {1,2,3,3,4,5,6};
        int[] result = new int[1];
        boolean b = new DuplicationVersion().findDup(a,a.length,result);
        if(b){
            System.out.println(b + " " + result[0]);
        }else {
            System.out.println(b);
        }

    }
}
