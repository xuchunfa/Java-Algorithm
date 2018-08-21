package cn.xuchunfa.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @description: 无序数组中第k大的数
 * @author: Xu chunfa
 * @create: 2018-08-20 16:00
 **/
public class KthBiggestNumber {

    public static int findKthNum(int[] num,int start,int end,int k){

        if(num == null){
            throw new RuntimeException("输入数组");
        }

        if(num.length == 0){
            throw new RuntimeException("数组不能为空");
        }

        if(start < 0 || end >= num.length || k > num.length || k < 1){
            throw new RuntimeException("参数不合法");
        }

        int position = partition(num,start,end);


        if(position < k - 1){
            return findKthNum(num,position+1,end,k);
        }else if(position > k - 1){
            return findKthNum(num,start,position-1,k);
        }else{
            return num[position];
        }
    }


    //使用循环的解法
    public static int findKthNumOther(int[] a,int k){

        if(a == null){
            throw new RuntimeException("数组不存在");
        }

        if(k < 0 || k > a.length){
            throw new RuntimeException("参数非法");
        }

        int i,j,pivot;
        int low = 0;
        int high = a.length - 1;

        while (low <= high){
            i = low;
            j = high;
            pivot = a[low];

            //大值放 pivot 前面
            while (i < j){
                while (a[j] <= pivot && i < j)
                    j--;

                a[i] = a[j];//从后往前找到第一个比轴大的值

                while(a[i] >= pivot && i < j)
                    i++;

                a[j] = a[i];//从前往后找到第一个比轴小的值
            }

            a[i] = pivot;

            //i 看成 position
            if(i < k - 1){
                low = i + 1;
            }else if(i > k - 1){
                high = i - 1;
            }else {// i = k-1
                return a[i];
            }
        }
        return -1;
    }

    //使用优先队列的解法
    public static int findKthNumByPriortyQueue(int[] a,int k){

        if(a == null){
            throw new RuntimeException("数组不存在");
        }

        if(k < 0 || k > a.length){
            throw new RuntimeException("参数非法");
        }

        int length = a.length;

        PriorityQueue<Integer> priority = new PriorityQueue<Integer>();

        //会以Int型数据进行自然排序
        for(int num : a){
            priority.add(num);
        }

        //把前 length - k 个元素全部出队
        int i = 0;
        while(i < length - k){
            priority.poll();
            i++;
        }

        //priority[length - k]为升序队列中的第K大的数
        return priority.peek();
    }

    //数组左边的值大于轴值,右边小于轴值
    public static int partition(int[] a,int start,int end){
        int i,j,pivot;
        i = start;
        j = end;

        //轴值在[start,end]区间内随机生成,然后把轴值交换到数组中第一位
        rand_pivot(a,start,end);

        //第一个选出来的数是区间内随机生成的
        pivot = a[i];

        while (i < j){
            while (a[j] <= pivot && i < j)
                j--;

            a[i] = a[j];//从后往前找到第一个比轴大的值

            while(a[i] >= pivot && i < j)
                i++;

            a[j] = a[i];//从前往后找到第一个比轴小的值
        }

        a[i] = pivot;

        //此时返回i,j都行
        return i;

        //此种写法必须返回i,不能返回j
        /*while (i < j){
            while (a[j] < pivot && i < j)
                j--;

            a[i++] = a[j];//从后往前找到第一个比轴大的值

            while(a[i] > pivot && i < j)
                i++;

            a[j--] = a[i];//从前往后找到第一个比轴小的值
        }

        return i;*/
    }

    //
    private static void rand_pivot(int[] a, int start, int end) {
        Random random = new Random();
        int rand = start + random.nextInt(end - start + 1);//随机函数生成的整数区间在[0,length)

        //交换第一个数和随机选出来的数
        int temp = a[start];
        a[start] = a[rand];
        a[rand] = temp;

    }

    public static void main(String[] args){
        int[] a = {3,2,1,4,4,5};
        System.out.println(KthBiggestNumber.findKthNum(a,0,a.length-1,6));
        System.out.println(Arrays.toString(a));
    }


}
