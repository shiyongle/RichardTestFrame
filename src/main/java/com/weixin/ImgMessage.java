package com.weixin;

/**
 * @Author: Richered
 * @Date: 2020/11/26 11:33
 * @Description 图片消息
 */
public class ImgMessage {

    private Media image;

    private int safe;

    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
