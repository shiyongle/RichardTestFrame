package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:09
 * @Description:
 */
public class PrintStackTraceTest {
    public static void main(String[] args) throws SelfException {
        firstMethod();
    }

    public static void firstMethod() throws SelfException {
        secondMethod();
    }

    public static void secondMethod() throws SelfException {
        thirdMethod();
    }

    public static void thirdMethod() throws SelfException {
        throw new SelfException("自定义异常消息");
    }
}
