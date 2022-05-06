package com.leetcode.algorithm;

/**
 * @Descriotion 顺时针打印矩阵
 * @Date 2022/5/6 23:58
 * @Created by shiyl
 */
public class PrintMatrix {
    public void printMatrix(int[][] matrix) {
        if(matrix==null || matrix.length<=0)
            return;
        printMatrixInCircle(matrix, 0);
    }

    private void printMatrixInCircle(int[][] matrix,int start) {
        int row=matrix.length;
        int col=matrix[0].length;
        int endX=col-1-start;
        int endY=row-1-start;
        if(endX<start || endY<start)
            return;
        //仅一行
        if(endY==start) {
            for(int i=start;i<=endX;i++) {
                System.out.print(matrix[start][i]+" ");
            }
            return;  //记得结束
        }
        //仅一列
        if(endX==start) {
            for(int i=start;i<=endY;i++) {
                System.out.print(matrix[i][start]+" ");
            }
            return;  //记得结束
        }

        //打印边界
        for(int i=start;i<=endX;i++) {
            System.out.print(matrix[start][i]+" ");
        }
        for(int i=start+1;i<=endY;i++) {
            System.out.print(matrix[i][endX]+" ");
        }
        for(int i=endX-1;i>=start;i--) {
            System.out.print(matrix[endY][i]+" ");
        }
        for(int i=endY-1;i>=start+1;i--) {
            System.out.print(matrix[i][start]+" ");
        }

        //继续打印更内部的矩阵，令start+1
        printMatrixInCircle(matrix, start+1);
    }


    public static void main(String[] args) {
        PrintMatrix demo = new PrintMatrix();
        int[][] a= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        demo.printMatrix(a);
    }
}
