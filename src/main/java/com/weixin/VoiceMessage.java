package com.weixin;

/**
 * @Author: Richered
 * @Date: 2020/11/26 11:33
 * @Description 语音消息
 */
public class VoiceMessage {

    private Media voice;

    private int safe;

    public Media getVoice() {
        return voice;
    }

    public void setVoice(Media voice) {
        this.voice = voice;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
