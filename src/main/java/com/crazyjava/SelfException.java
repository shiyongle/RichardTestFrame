package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:09
 * @Description:
 */
public class SelfException extends Exception {
    SelfException(){}

    SelfException(String msg){
        super(msg);
    }
}
