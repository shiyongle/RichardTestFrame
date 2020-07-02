package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/2 10:23
 * Description:
 */
public class IdentityHashCodeTest {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode() + "----" + s2.hashCode());

        //不同的字符串对象，因此identityHashCode值不同
        System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));

        String s3 = "Java";
        String s4 = "Java";
        //相同的字符串对象，因此相同
        //identityHashCode值可以标识唯一对象
        System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));
    }
}
