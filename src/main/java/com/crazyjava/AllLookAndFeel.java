package com.crazyjava;

import javax.swing.*;

/**
 * @Author: Richered
 * @Date: 2020/07/24 13:15
 * @Description:
 **/
public class AllLookAndFeel {
    public static void main(String[] args) {
        System.out.println("当前系统可用的所有LAF");
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            System.out.println(info.getName() + "-->" + info);
        }
    }
}
