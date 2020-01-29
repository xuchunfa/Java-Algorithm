import java.util.Scanner;

/**
 * @description: leetcode路径问题
 *               从左上角走到右下角一共多少种走法
 *
 *               另一种变体：
 *               输入:
                    [
                    [1,3,1],
                    [1,5,1],
                    [4,2,1]
                    ]
                输出: 7
                解释: 因为路径 1→3→1→1→1 的总和最小。

 * @author: Xu chunfa
 * @create: 2019-07-22 21:12
 **/
public class ShoppeeMN {
    private static int counter = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String nums = in.nextLine();
        String[] strs = nums.split("\\s+");
        int endX = Integer.valueOf(strs[0]);
        int endY = Integer.valueOf(strs[1]);
        int bossNum = Integer.valueOf(strs[2]);
        int rows = endX+1;
        int cols = endY+1;
        //走法数可能大于Integer.MAX_VALUE
        long[][] matrix = new long[rows][cols];

        //第一行的元素都只有一种到法
        for(int i = 0; i <cols;i++){
            matrix[0][i] = 1;
        }

        for(int i = 0;i < rows;i++){
            matrix[i][0] = 1;
        }

        //指定元素不能走
        for(int i = 0;i < bossNum;i++){
            String num = in.nextLine();
            String[] str = num.split("\\s+");
            int j = Integer.valueOf(str[0]);//行
            int k = Integer.valueOf(str[1]);//列
            matrix[j][k] = -1;
        }

        for(int i = 1;i < rows;i++){
            for(int j = 1;j < cols;j++){
                if(matrix[i][j] == -1)//不让走
                    continue;
                if(matrix[i][j-1] != -1)
                    matrix[i][j] += matrix[i][j-1];
                if(matrix[i-1][j] != -1)
                    matrix[i][j] += matrix[i-1][j];
            }
        }
        System.out.println(matrix[rows-1][cols-1]);
    }

    public static boolean find(int[] matrix, int i, int j, int rows, int cols, int[] visited) {

        if(i == rows - 1 && j == cols - 1){
            ++counter;
            //继续遍历
            return false;
        }

        int index = i * rows + j;
        if(i >= rows || j >= cols || visited[index] == 1)//避开boss
            return false;

        boolean res = find(matrix,i,j+1,rows,cols,visited) ||
                find(matrix,i+1,j,rows,cols,visited);

        return res;
    }
}
