package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:22
 * @Description:
 */
public interface MyUtil<E> {
    public static <Z> MyUtil<Z> nil(){
        return null;
    }

    public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail){
        return null;
    }

    default E head(){
        return null;
    }
}
