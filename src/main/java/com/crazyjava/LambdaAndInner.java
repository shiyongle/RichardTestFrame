package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 16:09
 * Description:
 */
public class LambdaAndInner {
    private int age = 12;
    private static String name = "疯狂软件教育中心";

    public void test(){
        String book = "疯狂java讲义";
        Displayable dis = () ->{
            System.out.println("book的局部变量为:" + book);
            System.out.println("外部类age的实例变量为:" + age);
            System.out.println("外部类的name变量为:" + name);
        };
        dis.display();
        System.out.println(dis.add(3, 5));
    }

    public static void main(String[] args) {
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
    }
}
