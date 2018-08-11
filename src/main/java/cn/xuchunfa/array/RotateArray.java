package cn.xuchunfa.array;

/**
 * @description: 找出旋转数组中的最小值
 * @author: Xu chunfa
 * @create: 2018-07-28 19:54
 **/
public class RotateArray {

    //如果把排序数组的前0个元素搬到最后面,算法得不到正确结果
    public static int minElement2(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        if(a.length == 0){
            throw new RuntimeException("数组为空");
        }

        int low = 0;
        int high = a.length-1;
        int media;
        while (low < high){

            if(high == low + 1){
                return a[high];
            }

            media = (low + high)/2;
            if(a[media] >= a[low]){
                low = media;
            }else if(a[media] <= a[high]){
                high = media;
            }
        }
        return a[high];
    }

    //解决了a = {1,2,3} 的问题
    public static int minElement1(int[] a){

        if(a == null){
            throw new RuntimeException("输入数组");
        }

        if(a.length == 0){
            throw new RuntimeException("数组为空");
        }

        int low = 0;
        int high = a.length-1;
        int media = low;

        while (a[low] >= a[high]){

            if(high == low + 1){
                media = high;
                break;
            }

            media = (low + high)/2;

            if(a[media] >= a[low]){
                low = media;
            }else if(a[media] <= a[high]){
                high = media;
            }
        }

        return a[media];
    }

    //解决了 a = {0,1,1,1,1} --> {1,0,1,1,1}的情况
    public static int minElement(int[] a){
        if(a == null){
            throw new RuntimeException("输入数组");
        }

        if(a.length == 0){
            throw new RuntimeException("数组为空");
        }

        int low = 0;
        int high = a.length-1;
        int media = low;

        while (a[low] >= a[high]){

            if(high == low + 1){
                media = high;
                break;
            }

            media = (low + high)/2;

            //顺序查找
            if(a[low] == a[high] && a[low] == a[media]){
                return fromBeginToEnd(a,low,high);
            }

            if(a[media] >= a[low]){
                low = media;
            }else if(a[media] <= a[high]){
                high = media;
            }
        }
        return a[media];
    }

    private static int fromBeginToEnd(int[] a,int start,int end) {
        int min = a[start];
        for(int i = start;i<end;i++){
            if(a[i] < min){
                min = a[i];
            }
        }

        return min;
    }

    public static void main(String[] args){
        int[] a = {1,1,1,0,1};
        System.out.println(RotateArray.minElement(a));
    }
}
