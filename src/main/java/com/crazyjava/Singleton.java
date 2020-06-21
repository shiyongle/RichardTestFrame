package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:37
 * @Description:
 */
public class Singleton {
    /**
     * 使用一个类变量来缓存曾经创建的实例
     */
    private static Singleton instance;
    private Singleton(){}

    /**
     * 提供一个静态方法，用于返回Singleton实例
     * 该方法可以加入自定义控制，保证只产生一个Singleton对象
     * @return
     */
    public static Singleton getInstance(){
        /**
         * 如果为空，则创建该Singleton对象
         * 如果不为空，则表明已经创建了Singleton实例，不需要再创建，返回其缓存
         */
        if (instance == null){
            //创建，并缓存
            instance = new Singleton();
        }
        return instance;
    }
}
