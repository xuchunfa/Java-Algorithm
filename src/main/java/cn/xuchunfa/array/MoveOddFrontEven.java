package cn.xuchunfa.array;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-01 20:11
 **/
public class MoveOddFrontEven {

    //时间换空间
    public void reOrderArray(int [] array) {
        if(array == null)
            throw new RuntimeException("array is not existed");
        if(array.length == 0){
            return;
        }

        int[][] bucket = new int[2][array.length];
        int evenIndex = 0;
        int oddIndex = 0;
        for(int i = 0;i < array.length;i++){
            if((array[i] & 1) == 0){
                bucket[0][evenIndex++]=array[i];
            }else{
                bucket[1][oddIndex++]=array[i];
            }
        }
        int k = 0;
        for(int i = 0;i < oddIndex;i++){
            array[k] = bucket[1][i];
            k++;
        }
        for(int i = 0;i < evenIndex;i++){
            array[k] = bucket[0][i];
            k++;
        }
    }

    //时间复杂度最差为：O(n2)
    public void reOrderArray2(int [] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;
        while(i<a.length){
            while(i < a.length && (a[i] & 1) == 1)
                i++;
            j = i+1;
            while(j<a.length && (a[i] & 1) == 0)
                j++;
            if(j<a.length){
                int tmp = a[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    a[j2+1] = a[j2];
                }
                a[i++] = tmp;
            }else{
                break;
            }
        }
    }
}
