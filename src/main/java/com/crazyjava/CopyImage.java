package com.crazyjava;

import java.awt.*;
import java.awt.Canvas;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/7/23 23:01
 * @Description:
 */
public class CopyImage {
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    java.util.List<Image> imageList = new ArrayList<>();

    private final int AREA_WIDTH = 500;

    private final int AREA_HEIGHT = 400;

    private int preX = -1;

    private int preY = -1;

    PopupMenu pop = new PopupMenu();

    MenuItem redItem = new MenuItem("红色");

    MenuItem greenItem = new MenuItem("绿色");

    MenuItem blueItem = new MenuItem("蓝色");

    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    Graphics g = image.getGraphics();

    private Frame f = new Frame("简单手绘程序");


//    class DrawCanvas extends Canvas {
//        public void paint(Graphics g){
//            g.drawImage(image, 0, 0, null);
//            for (Image img : imageList){
//                g.drawImage(img, 0, 0, null);
//            }
//        }
//    }

    public static void main(String[] args) {
//        new CopyImage().init()
    }
}
