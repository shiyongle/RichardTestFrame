package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/08/22 15:34
 * @Description: 自动一注解
 * 使用该注解的方法 : @TestUtils
 * 调用的时候必须赋值，要么需要赋一个初始值
 **/
public @interface TestUtils {
    String name() default "yeeku";
    int age() default 32;
}
