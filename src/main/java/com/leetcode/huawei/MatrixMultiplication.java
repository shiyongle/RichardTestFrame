package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 矩阵乘法
 */
public class MatrixMultiplication {
    public MatrixMultiplication() {
    }
    public int[][] mul(int[][] mat1, int [][]mat2) {
        int x = mat1.length, y = mat2.length, z = mat2[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        MatrixMultiplication solution = new MatrixMultiplication();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            int[][] mat1 = new int[x][y];
            int[][] mat2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    mat1[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    mat2[i][j] = in.nextInt();
                }
            }
            int[][] res = solution.mul(mat1, mat2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
