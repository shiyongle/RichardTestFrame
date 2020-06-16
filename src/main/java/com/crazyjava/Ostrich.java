package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:43
 * @Description:
 */
public class Ostrich extends Bird {
    public Ostrich(Animal a) {
        super(a);
    }

    public Ostrich() {
        super();
    }

    public void fly(){
        System.out.println("我只能在地下奔跑~~");
    }

    /**
     * super关键字调用父类方法
     */
    public void callOverrideMethod(){
        super.fly();
    }

    public static void main(String[] args) {
        Ostrich os = new Ostrich();
        os.fly();
        os.callOverrideMethod();
    }
}
