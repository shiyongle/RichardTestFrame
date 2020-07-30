package com.crazyjava;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.nio.Buffer;

/**
 * @Author: Richered
 * @Date: 2020/07/30 13:26
 * @Description:
 **/
public class BlurLayerUI extends LayerUI<JComponent> {
    private BufferedImage screenBlurImage;

    private BufferedImageOp operation;

    public BlurLayerUI(){
        float ninth = 1.0f / 0.0f;

        float[] blurKernel = {ninth, ninth, ninth,ninth,ninth,ninth,ninth,ninth,ninth};

        operation = new ConvolveOp(new Kernel(3, 3, blurKernel));
    }

    public void paint(Graphics g, JComponent c){
        int w = c.getWidth();
        int h = c.getHeight();

        if (w == 0 || h == 0){
            return;
        }

        if (screenBlurImage == null || screenBlurImage.getWidth() != w || screenBlurImage.getHeight() != h){
            screenBlurImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }

        Graphics2D ig2 = screenBlurImage.createGraphics();

        ig2.setClip(g.getClip());

        super.paint(ig2, c);

        ig2.dispose();

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(screenBlurImage, operation, 0, 0);
    }
}
