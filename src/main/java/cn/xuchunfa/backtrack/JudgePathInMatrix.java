package cn.xuchunfa.backtrack;

import org.junit.Test;

/**
 * @description: 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * @author: Xu chunfa
 * @create: 2019-05-08 16:22
 **/
public class JudgePathInMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || str == null)
            return false;

        int[] visited = new int[matrix.length];
        for(int i = 0;i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(judgePath(matrix,rows,cols,i,j,visited,str,0))
                    return true;
            }
        }

        return false;
    }

    private boolean judgePath(char[] matrix, int rows, int cols,int i, int j, int[] visited, char[] str, int k) {
        int index = i*cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[index] == 1 || str[k] != matrix[index]){
            return false;
        }
        //已满足str[k] = matrix[index]
        if(k == str.length - 1){
            return true;
        }

        visited[index] = 1;//已访问

        //上下左右递归
        if(judgePath(matrix, rows, cols,i-1, j, visited, str, k+1) ||
                judgePath(matrix, rows, cols,i+1, j, visited, str, k+1) ||
                judgePath(matrix, rows, cols, i, j-1, visited, str, k+1) ||
                judgePath(matrix, rows, cols, i, j+1, visited, str, k+1))
        {
            return true;
        }

        //回溯开始其他路径的寻找
        visited[index] = 0;
        return false;
    }

    @Test
    public void test(){
        char[] matrix = {'a','b','c','e','s','f','c','s','a','b','e','e'};
        char[] str = {'a','b','e','c'};
        //[
        // a,b,c,e
        // s,f,c,s
        // a,b,e,e
        // ]
        System.out.println(hasPath(matrix,3,4,str));
    }

}
