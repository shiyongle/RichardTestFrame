package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/02 18:22
 * @Description:
 **/
public class ListRenderingTest {

    private JFrame mainWin = new JFrame("好友列表");

    private String[] friends = new String[]{
            "李清照",
            "苏格拉底",
            "李白",
            "弄玉",
            "虎头"
    };

    private JList friendsList = new JList(friends);

    public void init(){
        friendsList.setCellRenderer(new ImageCellRender());

        mainWin.add(new JScrollPane(friendsList));

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.pack();

        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new ListRenderingTest().init();
    }

    class ImageCellRender extends JPanel implements ListCellRenderer{

        private ImageIcon icon;

        private String name;

        private Color background;

        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            icon = new ImageIcon("ico/" +value + ".gif");

            name = value.toString();

            background = isSelected ? list.getSelectionBackground() : list.getBackground();

            foreground = isSelected ? list.getSelectionForeground() : list.getForeground();

            return this;
        }

        public void paintComponent(Graphics g){

            int imageWidth = icon.getImage().getWidth(null);

            int imageHeight = icon.getImage().getHeight(null);

            g.setColor(background);

            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(foreground);

            g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);

            g.setFont(new Font("Sanserif", Font.BOLD, 18));

            g.drawString(name, getWidth() / 2 - name.length() * 10, imageWidth + 30);
        }

        public Dimension getPreferredSize(){
            return new Dimension(60, 80);
        }
    }
}
