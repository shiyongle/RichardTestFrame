package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:48
 * @Description:
 */
public class SubClass extends BaseClass {
    public int a = 7;
    public String book = "轻量级Java EE企业应用实战";

    public void test(){
        System.out.println("子类覆盖父类的方法");
    }

    public void sub(){
        System.out.println("子类的普通方法");
    }

    public void accessOwner(){
        System.out.println(a);
    }

    public void assessBase(){
        System.out.println(super.a);
    }



    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.accessOwner();
        sc.assessBase();

        BaseClass bc = new BaseClass();
        System.out.println("调用父类对象成员变量：" + bc.book);
        bc.base();
        bc.test();

        SubClass scs = new SubClass();
        System.out.println("调用子类对象成员变量：" + scs.book);
        scs.test();
        scs.sub();

        BaseClass ploymophicBc = new SubClass();
        System.out.println("访问父类对象实例的实例变量：" + ploymophicBc.book);
        ploymophicBc.base();        //调用继承父类的方法base
        ploymophicBc.test();        //调用当前类的的test方法
    }
}
