package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:54
 * Description:
 */
public class ProcessArray {
    public void process(int[] target, Command cmd){
        for (int t : target){
            cmd.process(t);
        }
    }
}
