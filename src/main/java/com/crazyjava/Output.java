package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 22:30
 * @Description:
 */
public interface Output {
    int MAX_CACHE_LINE = 50;

    void out();

    void getData(String msg);

    default void print(String... msgs){
        for (String msg : msgs){
            System.out.println(msg);
        }
    }

    default void test(){
        System.out.println("默认的test()方法");
    }

    static String staticTest(){
        return "接口里的方法";
    }

    static void foo(){
        System.out.println("foo的私有方法");
    }

    static void bar(){
        System.out.println("bar私有静态方法");
    }
}
