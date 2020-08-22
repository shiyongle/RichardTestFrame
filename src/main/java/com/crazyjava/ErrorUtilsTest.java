package com.crazyjava;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/08/19 16:58
 * @Description:
 **/
public class ErrorUtilsTest {

    public static void main(String[] args) {
        ErrorUtils.faultyMethod(Arrays.asList("hello!"), Arrays.asList("World!"));
    }
}
