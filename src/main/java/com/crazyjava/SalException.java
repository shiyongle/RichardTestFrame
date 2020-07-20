package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:06
 * @Description:
 */
public class SalException extends Exception{
    public SalException(){}

    public SalException(String msg){
        super(msg);
    }

    public SalException(Throwable t){
        super(t);
    }
}
