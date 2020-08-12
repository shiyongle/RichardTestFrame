package com.crazyjava;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/09 21:07
 * @Description:
 **/
public class GenderTableCellRenderer extends JPanel implements TableCellRenderer {

    private String cellValue;

    final int ICON_WIDTH = 23;

    final int ICON_HEIGHT = 23;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        cellValue = (String) value;

        if (hasFocus){
            setBorder(UIManager.getBorder("Table.focusCellHeighligthBorder"));
        }else {
            setBorder(null);
        }
        return this;
    }

    public void paint(Graphics g){
        if (cellValue.equalsIgnoreCase("男") || cellValue.equalsIgnoreCase("male")){
            drawImage(g, new ImageIcon("icon/male.gif").getImage());
        }
        if (cellValue.equalsIgnoreCase("女") || cellValue.equalsIgnoreCase("female")){
            drawImage(g, new ImageIcon("icon/female.gif").getImage());
        }
    }

    public void drawImage(Graphics g, Image imgae){
        g.drawImage(imgae, (getWidth() - ICON_WIDTH) / 2, (getHeight() - ICON_HEIGHT) / 2, null);
    }
}
