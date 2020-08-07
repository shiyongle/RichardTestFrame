package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/04 12:25
 * @Description:
 **/
public class ImageCellRenderer extends JPanel implements TreeCellRenderer {

    private ImageIcon icon;

    private Color background;

    private Color foreground;

    private String name;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        icon = new ImageIcon("ico/" + value + ".gif");

        name = value.toString();

        background = hasFocus ? new Color(140, 200, 235) : new Color(255, 255, 255);

        foreground = hasFocus ? new Color(255, 255, 0) : new Color(0,0,0);

        return this;
    }

    public void paintComponent(Graphics g){

        int imageWidth = icon.getImage().getWidth(null);

        int imageHeight = icon.getImage().getHeight(null);

        g.setColor(background);

        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(foreground);

        g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);

        g.setFont(new Font("SansSerif", Font.BOLD, 18));

        g.drawString(name, getWidth() / 2 - name.length() * 10, imageHeight + 30);
    }

    public Dimension getPreferredSize(){
        return new Dimension(80, 80);
    }
}
