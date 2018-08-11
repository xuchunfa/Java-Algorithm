package cn.xuchunfa.backtrack;

/**
 * @description: 矩阵路径
 * @author: Xu chunfa
 * @create: 2018-08-06 14:05
 **/
public class MatrixPath {

    public static boolean hasPath(char[][] a,int rows,int cols,String str){
        if(a == null || rows < 1 || cols < 1 || str == null)
            throw new RuntimeException("参数非法");

        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for(int row = 0;row < rows;row++){
            for(int col = 0;col < cols;col++){
                if(hasOnePath(a,row,col,rows,cols,str,pathLength,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasOnePath(char[][] a, int row, int col, int rows, int cols, String str,int pathLength,boolean[][] visited) {
        boolean result = false;
        if(str.length() == pathLength){
            return true;
        }

        if(row >= 0 && row < rows && col >= 0 && col < cols && a[row][col] == str.charAt(pathLength) && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;

            result = hasOnePath(a, row - 1, col, rows, cols, str, pathLength, visited) ||
                    hasOnePath(a, row, col - 1, rows, cols, str, pathLength, visited) ||
                    hasOnePath(a, row + 1, col, rows, cols, str, pathLength, visited) ||
                    hasOnePath(a, row, col + 1, rows, cols, str, pathLength, visited);

            if (!result) {
                --pathLength;
                visited[row][col] = false;
            }
        }

        return result;
    }

    public static void main(String[] args){
        /*char[][] a = {{'a','b','t','g'},
                    {'c','f','c','s'},
                    {'j','d','e','h'}};*/
        char[][] a = {{'a'},
                      {'f'},
                      {'g'},
                      {'d'}};

        String str = "gl";
        System.out.println(MatrixPath.hasPath(a,4,1,str));
    }
}
