package com.crazyjava;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.beans.PropertyChangeEvent;

/**
 * @Author: Richered
 * @Date: 2020/7/30 20:50
 * @Description:
 */
public class WaitingLayerUI extends LayerUI<JComponent> {
    private boolean isRunning;

    private Timer timer;

    private int angle;

    public void paint(Graphics g, JComponent c){
        super.paint(g, c);
        int w = c.getWidth();
        int h = c.getHeight();

        if (!isRunning){
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        Composite unComposite = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
        g2.fillRect(0, 0, 2, h);
        g2.setComposite(unComposite);
        int s = Math.min(w, h) / 5;
        int cx = w / 2;
        int cy = h / 2;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(s / 2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setPaint(Color.BLUE);
        g2.rotate(Math.PI * angle / 180, cx, cy);
        for (int i = 0; i < 12; i ++){
            float scale = (11.0f - (float) i) / 11.0f;
            g2.drawLine(cx + s, cy, cx + s * 2, cy);
            g2.rotate(-Math.PI / 6, cx, cy);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, scale));
        }
        g2.dispose();
    }

    public void start(){
        if (isRunning){
            return;
        }

        isRunning = true;
        timer = new Timer(100, e ->{
            if (isRunning){
                firePropertyChange("crazyitFlag", 0, 1);
                angle += 6;
                if (angle >= 360){
                    angle = 0;
                }
            }
        });
        timer.start();
    }

    public void stop(){
        isRunning = false;
        firePropertyChange("crazyitFlag", 0, 1);
        timer.stop();
    }

    public void applyPropertyChange(PropertyChangeEvent pce, JLayer layer){
        if (pce.getPropertyName().equals("crazyitFlag")){
            layer.repaint();
        }
    }
}
