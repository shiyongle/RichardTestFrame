package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:42
 * @Description:
 */
public class OverLoad {
    public void test(){
        System.out.println("无参数");
    }

    public void test(String msg){
        System.out.println("重载的方法" +msg);
    }

    public static void main(String[] args) {
        OverLoad ol = new OverLoad();
        ol.test();
        ol.test("哈哈哈哈哈，重载实现");
    }
}
