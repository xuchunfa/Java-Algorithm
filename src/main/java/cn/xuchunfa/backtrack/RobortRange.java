package cn.xuchunfa.backtrack;


import org.junit.Test;

/**
 * @description: 机器人的运动范围
 * @author: Xu chunfa
 * @create: 2019-05-09 10:23
 **/
public class RobortRange {

    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] visited = new int[rows][cols];
        return calRange(rows,cols,0,0,visited,threshold);
    }

    public int calRange(int rows,int cols,int i,int j,int[][] visited,int threshold){
        int bitsum = calBitSum(i) + calBitSum(j);

        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] == 1 || bitsum > threshold)
            return 0;

        visited[i][j] = 1;
        return calRange(rows,cols,i+1,j,visited,threshold) +
                calRange(rows,cols,i-1,j,visited,threshold) +
                calRange(rows,cols,i,j-1,visited,threshold) +
                calRange(rows,cols,i,j+1,visited,threshold) + 1;

    }

    public int calBitSum(int num){
        int sum = 0;
        while(num != 0){
            int bit = num%10;
            sum += bit;
            num /= 10;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(movingCount(5,7,9));
    }
}
