package com.sxt.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Author: Richered
 * @Date: 2020/5/13 23:21
 * @Description:
 */
public class GameUtil {
    /**
     * 工具类的构造器方法私有化
     */
    private GameUtil(){}

    /**
     * 返回指定路径图片对象
     * @param path
     * @return
     */
    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
