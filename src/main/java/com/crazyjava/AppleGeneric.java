package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:29
 * @Description: 泛型声明<T> 不用考虑，包括在实体方法中的T声明类型，因为在实例化的时候才会定义其类型
 */
public class AppleGeneric<T> {
    private T info;

    public AppleGeneric(T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        AppleGeneric<String> a1 = new AppleGeneric<>("苹果");
        System.out.println(a1.info);

        AppleGeneric<Double> a2 = new AppleGeneric<>(22.2);
        System.out.println(a2.info);
    }
}
