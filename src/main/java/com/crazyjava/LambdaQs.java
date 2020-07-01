package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 14:17
 * Description:
 */
public class LambdaQs {
    /**
     * 调用该方法需要Eatable对象
     * @param e
     */
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }

    /**
     * 调用该方法需要Flyable对象
     * @param f
     */
    public void drive(Flyable f){
        System.out.println("我正在驾驶:" + f);
        f.fly("【碧空如洗的晴天】");
    }

    public void test(Addable add){
        System.out.println("5与3的和为：" + add.add(5, 3));
    }

    public static void main(String[] args) {
        LambdaQs lq = new LambdaQs();
        /**
         * 只有一条语句可以省略花括号
         * 无形参
         */
        lq.eat(()->System.out.println("苹果的味道不错～"));

        /**
         * 一个形参，可省略形参中的参数列表圆括号
         */
        lq.drive(weather -> {
            System.out.println("今天的天气是：" + weather);
            System.out.println("直升机飞行平稳~");
        });

        /**
         * 只有一条语句可以省略花括号
         * 只有一条语句，即使该表达式需要返回值，也可以省略return
         */
        lq.test((a, b) -> a + b);
    }
}
