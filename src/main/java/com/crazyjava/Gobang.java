package com.crazyjava;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * @Author: Richered
 * @Date: 2020/6/10 1:01
 * @Description: 棋盘实现
 */
public class Gobang {

    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage selected;

    //定义棋盘大小
    private static int BOARD_SIZE = 15;

    private final int TABLE_WIDTH = 535;

    private final int TABLE_HETGHT = 536;

    private final int RATE = TABLE_WIDTH / BOARD_SIZE;

    private final int X_OFFSET = 5;

    private final int Y_OFFSET = 6;

    //定义个二位数组来充当棋盘
    private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];

    JFrame f = new JFrame("五子棋游戏");

    ChessBoard chessBoard = new ChessBoard();

    private int selectedX = -1;

    private int selectedY = -1;

    public void init() throws Exception{
        table = ImageIO.read(new File("image/board.jpg"));
        black = ImageIO.read(new File("image/black.jpg"));
        white = ImageIO.read(new File("image/white.jpg"));
        selected = ImageIO.read(new File("image/selected.gif"));

        for (int i = 0; i < BOARD_SIZE; i ++){
            for (int j = 0; j < BOARD_SIZE; j++){
                board[i][j] = "+";
            }
        }

        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HETGHT));
        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int xPos = (int)((e.getX() - X_OFFSET) / RATE);
                int yPos = (int)((e.getY() - Y_OFFSET) / RATE);
                board[xPos][yPos] = "o";
                chessBoard.repaint();
            }
            public void mouseExited(MouseEvent e){
                selectedX = -1;
                selectedY = -1;
                chessBoard.repaint();
            }
        });
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                selectedX = ((e.getX() - X_OFFSET) / RATE);
                selectedY = ((e.getY() - Y_OFFSET) / RATE);
                chessBoard.repaint();
            }
        });
        f.add(chessBoard);
        f.pack();
        f.setVisible(true);
    }

//    public void initBoard(){
//        //初始化棋盘数组
//        board = new String[BOARD_SIZE][BOARD_SIZE];
//        //把每个元素赋为“+”，用于在控制台画出棋盘
//        for (int i = 0; i < BOARD_SIZE; i ++){
//            for (int j = 0; j < BOARD_SIZE; j++){
//                board[i][j] = "+";
//            }
//        }
//
//    }

    class ChessBoard extends JPanel{
        public void paint(Graphics g){
            g.drawImage(table, 0, 0, null);
            if (selectedX >= 0 && selectedY >= 0){
                g.drawImage(selected, selectedX * RATE + X_OFFSET, selectedY * RATE + Y_OFFSET, null);
            }
            for (int i = 0; i < BOARD_SIZE; i++){
                for (int j = 0; j < BOARD_SIZE; j++){
                    if (board[i][j].equals("+")){
                        g.drawImage(black, i + RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                    }
                    if (board[i][j].equals("o")){
                        g.drawImage(white, i + RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                    }
                }
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

    public static void main(String[] args) throws Exception {
//        Gobang gb = new Gobang();
//        gb.initBoard();
//        gb.printBoard();
//        //获取键盘输入的方法
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String inputStr = null;
//        while ((inputStr = br.readLine()) != null){
//            //将用户输入的字符串以，分隔
//            String[] posStrArr = inputStr.split(",");
//            //将两个字符串转换成用户下棋的坐标
//            int xPos = Integer.parseInt(posStrArr[0]);
//            int yPos = Integer.parseInt(posStrArr[1]);
//            //把对应的数组元素赋为“@”
//            gb.board[yPos - 1][xPos - 1] = "@";
//            /**
//             * 随机生成2个随机数，作为电脑下棋的坐标，赋给board数组
//             */
//            gb.printBoard();
//            System.out.println("请输入您下棋的坐标，应以x，y格式：");
//        }
        Gobang gb = new Gobang();
        gb.init();
    }
}
