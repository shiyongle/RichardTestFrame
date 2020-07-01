package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:31
 * Description:
 */
public class AnonymousInner {
    public void test(Device d){
        System.out.println("购买了一个" + d.getName() + ",花掉了" + d.getPrice());
    }

    public static void main(String[] args) {
        AnonymousInner ai = new AnonymousInner();

        //调用有参数的构造器,创建device匿名类对象
        ai.test(new Device("电子示波器") {
            //实现接口方法
            @Override
            public double getPrice() {
                return 67.8;
            }
        });

        //调用无参构造器，创建device匿名实现类对象
        Device d = new Device() {
            @Override
            public double getPrice() {
                return 56.2;
            }

            //重写父类的实例方法
            public String getName(){
                return "键盘";
            }
        };

        ai.test(d);
    }
}
