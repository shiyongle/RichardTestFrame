package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:53
 * Description:
 */
public interface Command {
    /**
     * 接口里边定义process方法用于封装“处理行为”
     * @param element
     */
    void process(int element);
}
