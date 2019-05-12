package cn.xuchunfa.array;

import java.util.ArrayList;


/**
 * @description: 逆时针打印矩阵
 * @author: Xu chunfa
 * @create: 2019-04-02 21:37
 **/
public class PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int rowIndex = 0;
        int colIndex = 0;
        int i;
        while (rowIndex < row && colIndex < col){

            //第一行
            for(i = colIndex;i < col;i++){
                result.add(matrix[rowIndex][i]);
            }
            rowIndex++;

            //最后一列
            for(i = rowIndex;i < row;i++){
                result.add(matrix[i][col-1]);
            }
            col--;

            //最后一行
            if(rowIndex < row){
                for(i = col-1;i >= colIndex;i--){
                    result.add(matrix[row-1][i]);
                }
                row--;
            }

            //第一列
            if(colIndex < col) {
                for (i = row - 1; i >= rowIndex; i--) {
                    result.add(matrix[i][colIndex]);
                }
                colIndex++;
            }
        }
        return result;
    }

    //逆时针
    public static ArrayList<Integer> printMatrixOther(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int rowIndex = 0;
        int colIndex = 0;
        int i;
        while (rowIndex < row && colIndex < col){
            //第一列
            for(i = colIndex;i < row;i++){
                result.add(matrix[i][colIndex]);
            }
            colIndex++;

            //最后一行
            for(i = colIndex;i < col;i++){
                result.add(matrix[row-1][i]);
            }
            row--;

            //最后一列
            if(colIndex < col){
                for(i = row-1;i >= rowIndex;i--){
                    result.add(matrix[i][col-1]);
            }
                col--;
            }

            //第一行
            if(rowIndex < row){
                for(i=col-1;i >=colIndex;i--){
                    result.add(matrix[rowIndex][i]);
                }
                rowIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix= {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        System.out.println(PrintMatrix.printMatrixOther(matrix).toString());
    }

}
