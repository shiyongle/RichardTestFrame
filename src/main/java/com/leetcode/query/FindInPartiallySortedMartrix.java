package com.leetcode.query;

/**
 * @Descriotion 二维数组查询
 * @Date 2022/5/6 20:20
 * @Created by shiyl
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMartrix {

    public int[] find(int[][] matrix, int a){
        int[] index = {-1, -1};

        if (matrix == null || matrix.length<= 0){
            System.out.println("无效数组！");
            return index;
        }

        int colums = matrix[0].length;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i].length != colums) {
                System.out.println("数组列数不一致！");
                return index;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j == 0)
                    // matrix[0][0]不比较
                    break;
                if (i == 0) { // 第一行的数，仅和前一列的数比较
                    if (matrix[i][j] < matrix[i][j - 1]) {
                        System.out.println("数组中数字大小不符合要求！");
                        return index;
                    }
                } else if (j == 0) { // 第一列的数，仅和前一行的数比较
                    if (matrix[i][j] < matrix[i - 1][j]) {
                        System.out.println("数组中数字大小不符合要求！");
                        return index;
                    }
                } else if (matrix[i][j] < matrix[i - 1][j] || matrix[i][j] < matrix[i][j - 1]) {
                    // 其余位置的数字，和前一行或前一列的比较
                    System.out.println("数组中数字大小不符合要求！");
                    return index;
                }
            }
        }

        int row = 0;
        int column = matrix[0].length - 1;
        while (row <= matrix.length - 1 && column >= 0){
            if (a == matrix[row][column]){
                index[0] = row;
                index[1] = column;
                System.out.println("数字" + a + "在二维数组中的下标为：" + index[0] + "," + index[1]);
                return index;
            }else if (a < matrix[row][column]){
                column--;
            }else {
                row++;
            }
        }
        System.out.println("数组中不含数字:" + a);
        return index;
    }

    /**
     * 要查找的数在数组中
     */
    public void test1(){
        System.out.print("test1：");
        int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int[] index = find(matrix, 7);
    }
    /**
     * 要查找的数不在数组中
     */
    public void test2(){
        System.out.print("test2：");
        int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int[] index = find(matrix, 5);
    }

    /**
     * 数组为空
     */
    public void test3(){
        System.out.print("test3：");
        int[][] matrix = null;
        int[] index = find(matrix, 7);
    }


    // 数组不满足大小规则
    public void test4() {
        System.out.print("test4：");
        int[][] matrix = { { 1, 2, 8, 9 }, { 4, 3, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int[] index = find(matrix, 7);
    }

    // 数组每行长度不一致
    public void test5() {
        System.out.print("test5：");
        int[][] matrix = { { 1, 2, 8 }, { 4, 3, 9, 12 }, { 4, 7, 10 }, { 6, 8, 11, 15 } };
        int[] index = find(matrix, 7);
    }

    public static void main(String[] args) {
        FindInPartiallySortedMartrix f = new FindInPartiallySortedMartrix();
        f.test1(); // 注意下标是从0开始的
        f.test2();
        f.test3();
        f.test4();
        f.test5();
    }
}
