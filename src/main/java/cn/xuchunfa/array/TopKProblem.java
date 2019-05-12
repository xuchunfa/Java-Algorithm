package cn.xuchunfa.array;

import java.util.Arrays;
import java.util.Random;

import static cn.xuchunfa.sort.HeapSort.createHeap;

/**
 * @description: 堆排序解决TopK问题
 * @author: Xu chunfa
 * @create: 2018-08-21 16:21
 **/
public class TopKProblem {

    //时间复杂度:(n-K)*logK 空间复杂度:O(K)
    public static int[] createKtopHeap(int[] num,int k){
        int length = num.length;
        int i = 0;

        //通过堆维护Topk元素
        int[] KNumberHeap = new int[k];

        if(k >= length){
            k = length;
            return num;
        }

        //初始化有k个元素的堆
        for(; i < k; i++){
            KNumberHeap[i] = num[i];
        }

        //构建小顶堆
        for(int j = KNumberHeap.length/2-1;j >= 0;j--){
            createMinHeap(KNumberHeap,j,KNumberHeap.length);
        }

        //从第k+1个元素开始循环,每次都与堆顶元素(K个元素中的最小值)比较,大于就替代然后再调整.
        for(;i < length;i++){
            if(num[i] > KNumberHeap[0]){
                KNumberHeap[0] = num[i];
                createMinHeap(KNumberHeap,0,KNumberHeap.length);
            }
        }

        return KNumberHeap;
    }

    private static void createMinHeap(int[] a, int i , int len) {
        int father = a[i];
        int j;//j代表子结点坐标 i代表父结点坐标

        while(2*i + 1 < len){//如果i结点在堆顶上的话,需要自顶向下调整

            j = 2*i + 1;

            if(j + 1 < len && a[j] > a[j+1] )
                j++;

            if(a[j] < father){
                a[i] = a[j];
                i = j;
            }else {//不用调整的话就不用再向下循环了,子节点都已经调整好了
                break;
            }
        }
        //找到最终位置
        a[i] = father;
    }

    public static void main(String[] args){
        Random random = new Random();
        int[] num = new int[15];

        for(int i = 0;i < num.length;i++){
            num[i] = random.nextInt(50);
        }

        System.out.println(Arrays.toString(num));

        System.out.println(Arrays.toString(createKtopHeap(num,5)));
    }
}
