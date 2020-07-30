package com.crazyjava;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/30 13:15
 * @Description:
 **/
public class FirstLayerUI extends LayerUI<JComponent> {
    public void paint(Graphics g, JComponent c){
        super.paint(g, c);
        Graphics2D g2 = (Graphics2D)g.create();

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
        g2.setPaint(new GradientPaint(0,0 , Color.RED, 0, c.getHeight(), Color.BLUE));
        g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        g2.dispose();
    }
}
