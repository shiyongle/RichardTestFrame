package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 11:36
 * Description:
 */
public class AnonymousTest {
    public void test(ProductOne p){
        System.out.println("购买了一个" + p.getName() + ", 花掉了" + p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        /**
         * 因为test方法需要的是ProductOne对象，但是ProductOne是一个接口，则需要实现它
         */
        ta.test(new ProductOne() {
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "AGP显卡";
            }
        });

        //调用实现接口类
        ta.test(new AnonymousProduct());
    }
}
