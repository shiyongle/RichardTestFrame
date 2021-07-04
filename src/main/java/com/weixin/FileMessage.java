package com.weixin;

/**
 * @Author: Richered
 * @Date: 2020/11/26 11:35
 * @Description 文件消息
 */
public class FileMessage {

    private Media file;

    private int safe;

    public Media getFile() {
        return file;
    }

    public void setFile(Media file) {
        this.file = file;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
