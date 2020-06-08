package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 21:23
 * @Description: 比较运算符
 */
public class ComparableOperatorTest {
    public static void main(String[] args) {
        System.out.println("5是否大于4.0：" + (5 > 4.0));
        System.out.println("5是否等于5.0：" + (5 == 5.0));
        System.out.println("97是否与a相等：" + (97 == 'a'));
        System.out.println("true是否与false相等：" + (true == false));

        ComparableOperatorTest c1 = new ComparableOperatorTest();
        ComparableOperatorTest c2 = new ComparableOperatorTest();
        System.out.println("c1是否等于c2:" + (c1 ==c2));

        ComparableOperatorTest c3 = c1;
        System.out.println("c1是否等于c3：" + (c1 == c3));
    }
}
