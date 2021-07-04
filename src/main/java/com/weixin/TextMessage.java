package com.weixin;

/**
 * @Author: Richered
 * @Date: 2020/11/26 11:28
 * @Description 文本消息
 */
public class TextMessage extends BaseMessage{

    private Text text;

    private int safe;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
