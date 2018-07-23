package cn.xuchunfa.array;

/**
 * @description: 二维数组，每一行从左到右递增，每一列从上到下递增，是否包含指定 key
 * @author: Xu chunfa
 * @create: 2018-07-19 20:50
 **/
public class SearchIn2Array {

    public int findElement(int[][] arr,int n,int m,int search){

        int row = n;
        int col = m;
        int key = search;
        int i = 0;

        if(arr == null){
            System.out.println("请输入一个二维数组");
            return 0;
        }

        if(n <= 0 || m <=0){
            System.out.println("输入两个自然数");
        }

        while(i < row && col >0){
            //去列
            if(arr[i][col-1] > key){
                col--;
            }else if(arr[i][col-1] < key){
                i++;
            }else {
                //找到元素
                return arr[i][col-1];
            }

            //只剩一行
            if(i == row-1){
                for(int j=0;j<col;j++){
                    if(arr[i][j] == key) {
                        return arr[i][j];
                    }
                }

                return 0;
            }

            //只剩一列
            if(col == 1){
                for(int j = 0;j<row;j++){
                    if(arr[j][0] == key)
                        return arr[j][0];
                }

                return 0;
            }
        }

        //不存在
        return 0;
    }


    public static void main(String[] args){
        int[][] a = {{1,2,8,9},{2,4,9,12}, {5,7,10,13}, {6,8,11,20}};
        int result = new SearchIn2Array().findElement(a,4,4,11);
        System.out.println(result);
    }
}
