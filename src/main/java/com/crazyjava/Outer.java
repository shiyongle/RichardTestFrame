package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:23
 * Description:
 */
public class Outer {
    private int outProp = 9;

    class Inner{
        private int inProp = 5;
        public void accessOuterProp(){
            System.out.println("外部类的outProp值：" + outProp);
        }

        public void accessInnerProp(){
            System.out.println("内部类的inProp值:" + new Inner().inProp);
        }
    }

    public static void main(String[] args) {
        //创建了外部类对象，还未创建内部类对象,外部类对象调用内部类方法必然报错
        Outer ot = new Outer();
//        ot.accessInnerProp();
    }
}
