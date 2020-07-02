package com.crazyjava;

import java.util.Objects;

/**
 * @Author: Richered
 * @Date: 2020/7/2 11:35
 * Description:
 */
public class ObjectsTest {
    static ObjectsTest obj;

    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));
        System.out.println(Objects.requireNonNull(obj,"obj参数不能是null"));
    }
}
