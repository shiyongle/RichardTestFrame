package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 22:25
 * @Description:
 */
//定义上限为Number，传入的实际类型只能是Number或者Number的子类
public class AppleTwo<T extends Number> {
    T col;

    public static void main(String[] args) {
        AppleTwo<Integer> ai = new AppleTwo<>();
        AppleTwo<Double> ad = new AppleTwo<>();

        //试图将String类型传给T形参，但是String不是Number的子类型，所以会编译错误
//        AppleTwo<String> as = new AppleTwo<>();
    }
}
