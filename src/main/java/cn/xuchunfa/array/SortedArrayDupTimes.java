package cn.xuchunfa.array;

import org.junit.Test;

/**
 * @description: 排序数组中重复数字出现的次数
 * @author: Xu chunfa
 * @create: 2019-04-18 16:12
 **/
public class SortedArrayDupTimes {
    public int GetNumberOfK(int [] array , int k) {
        if(isAscend(array)){
            return findIndex(array,k+0.5) - findIndex(array,k-0.5);
        }
        return findIndex(array,k-0.5) - findIndex(array,k+0.5);
    }

    public boolean isAscend(int[] a){
        boolean flag = true;

        int low = 0;
        int high = a.length - 1;
        while (low < high){
            int middle = (low + high)/2;
            if(a[middle] > a[high]){
                flag = false;
                break;
            }else if(a[middle] < a[high]) {
                break;
            }else {
                high = middle;
            }
        }
        return flag;
    }

    public int findIndex(int[] array, double v) {
        int low = 0;
        int high = array.length - 1;
        if(isAscend(array)){//升序数组
            while (low <= high){
                int middle = (low + high)/2;
                if(array[middle] < v){
                    low = middle + 1;
                }else if(array[middle] > v){//不可能有相等的情况
                    high = middle - 1;
                }
            }
            return low;
        }else {//降序数组
            while (low <= high){
                int middle = (low + high)/2;
                if(array[middle] < v){
                    high = middle - 1;
                }else if(array[middle] > v){
                    low = middle + 1;
                }
            }
            return low;
        }
    }

    @Test
    public void test(){
        int[] a = {5,4,3,3,3,2,1};
        System.out.println(GetNumberOfK(a,3));
    }

}
