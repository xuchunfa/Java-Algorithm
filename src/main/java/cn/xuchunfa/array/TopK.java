package cn.xuchunfa.array;

import cn.xuchunfa.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-03-26 15:34
 **/
public class TopK {

    //递归求解第k大的数
    public static int kthLargest(int[] a,int l,int r,int k){
        if(k > 0 && k <= a.length){
            int partition = QuickSort.versePartition(a,l,r);
            if(partition == k - 1)
                return a[partition];
            if(partition < k - 1){
                return kthLargest(a,partition+1,r,k);
            }
            if(partition > k - 1){
                return kthLargest(a,l,partition-1,k);
            }
        }
        return Integer.MAX_VALUE;
    }

    //递归求解第k小的数
    public static int kthSmallest(int[] a,int l,int r,int k){
        if(k > 0 && k <= a.length){
            int partition = QuickSort.partition(a,l,r);
            if(partition == k - 1)
                return a[partition];
            if(partition < k - 1){
                return kthSmallest(a,partition+1,r,k);
            }
            if(partition > k - 1){
                return kthSmallest(a,l,partition-1,k);
            }
        }
        return Integer.MAX_VALUE;
    }

    //迭代求解第k小的数
    public static int kthSmallest1(int[] a,int k) {
        if (k > 0 && k <= a.length) {
            int low = 0;
            int high = a.length-1;
            while (low <= high){
                int partition = QuickSort.partition(a,low,high);
                if(partition == k - 1){
                    return a[partition];
                }
                if(partition < k - 1){
                    low = partition+1;
                }else {
                    high = partition-1;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        Random random = new Random();
        int[] num = {4,5,2,7,1,2,6,8};

        //for(int i = 0;i < num.length;i++){
        //    num[i] = random.nextInt(30);
        //}
        System.out.println(Arrays.toString(num));
        //System.out.println(kthSmallest(num,0,num.length-1,1));
        System.out.println(kthLargest(num,0,num.length-1,1));
        //System.out.println(kthSmallest1(num,4));
    }
}
