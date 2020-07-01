package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 16:52
 * Description:
 */
public class GenderTest {
    public static void main(String[] args) {
        //通过enum的valueof方法获取指定枚举类的枚举值
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        Gender g1 = Enum.valueOf(Gender.class, "MALE");
        g.setName("女");
        System.out.println(g + "代表：" + g.getName());
        g1.setName("男");
        System.out.println(g + "代表：" + g1.getName());
    }
}
