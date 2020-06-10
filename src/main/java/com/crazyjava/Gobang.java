package com.crazyjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Richered
 * @Date: 2020/6/10 1:01
 * @Description: 棋盘实现
 */
public class Gobang {
    //定义棋盘大小
    private static int BOARD_SIZE = 15;
    //定义个二位数组来充当棋盘
    private String[][] board;

    public void initBoard(){
        //初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        //把每个元素赋为“+”，用于在控制台画出棋盘
        for (int i = 0; i < BOARD_SIZE; i ++){
            for (int j = 0; j < BOARD_SIZE; j++){
                board[i][j] = "+";
            }
        }
    }

    /**
     * 在控制台输出棋盘的方法
     */
    public void printBoard(){
        //打印每个数组的元素
        for (int i = 0; i < BOARD_SIZE; i ++){
            for (int j = 0; j < BOARD_SIZE; j++){
                //打印数组元素后不换行
                System.out.println(board[i][j]);
            }
            //打印完一行数组元素后输出一个换行符
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();
        //获取键盘输入的方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = null;
        while ((inputStr = br.readLine()) != null){
            //将用户输入的字符串以，分隔
            String[] posStrArr = inputStr.split(",");
            //将两个字符串转换成用户下棋的坐标
            int xPos = Integer.parseInt(posStrArr[0]);
            int yPos = Integer.parseInt(posStrArr[1]);
            //把对应的数组元素赋为“@”
            gb.board[yPos - 1][xPos - 1] = "@";
            /**
             * 随机生成2个随机数，作为电脑下棋的坐标，赋给board数组
             */
            gb.printBoard();
            System.out.println("请输入您下棋的坐标，应以x，y格式：");
        }
    }
}
