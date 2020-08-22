package com.crazyjava;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * @Author: Richered
 * @Date: 2020/08/22 15:46
 * @Description:
 **/
public class MyTestable {

    @Testable
    public static void m1(){

    }

    public static void m2(){

    }

    @Testable
    public static void m3(){
        throw new IllegalArgumentException("参数出错了");
    }

    public static void m4(){

    }

    @Testable
    public static void m5(){

    }

    public static void m6(){

    }

    @Testable
    public static void m7(){
        throw new IllegalArgumentException("程序出错了");
    }

    public static void m8(){

    }
}
