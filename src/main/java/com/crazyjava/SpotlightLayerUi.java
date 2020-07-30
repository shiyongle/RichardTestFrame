package com.crazyjava;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 * @Author: Richered
 * @Date: 2020/7/30 20:38
 * @Description:
 */
public class SpotlightLayerUi extends LayerUI {
    private boolean active;

    private int cx, cy;

    public void installUI(JComponent c){
        super.installUI(c);
        JLayer layer = (JLayer) c;
        layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
    }

    public void uninstallUI(JComponent c){
        JLayer layer = (JLayer) c;
        layer.setLayerEventMask(0);
        super.uninstallUI(c);
    }

    public void paint(Graphics g, JComponent c){
        Graphics2D g2 = (Graphics2D) g.create();
        super.paint(g2, c);
        if (active){
            Point2D center = new Point2D.Float(cx, cy);
            float radius = 72;
            float[] dist = {0.0f, 1.0f};
            Color[] colors = {Color.YELLOW, Color.BLACK};
            RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
            g2.setPaint(p);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
            g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        g2.dispose();
    }

    public void processMouseEvent(MouseEvent e, JLayer layer){
        if (e.getID() == MouseEvent.MOUSE_ENTERED){
            active = true;
        }
        if (e.getID() == MouseEvent.MOUSE_EXITED){
            active = false;
        }
        layer.repaint();
    }

    public void processMouseMotionEvent(MouseEvent e, JLayer layer){
        Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), layer);
        cx = p.x;
        cy = p.y;
        layer.repaint();
    }
}
