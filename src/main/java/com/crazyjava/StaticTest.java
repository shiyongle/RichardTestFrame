package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:33
 * Description: 静态成员必须调用静态的内部类
 */
public class StaticTest {
    private static class In{}

    public static void main(String[] args) {
        new In();
    }
}
