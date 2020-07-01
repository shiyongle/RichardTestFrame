package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 14:57
 * Description:
 */

@FunctionalInterface
public interface Converter {
    /**
     * 将String转换为Integer
     * @param from
     * @return
     */
    Integer convert(String from);
}
