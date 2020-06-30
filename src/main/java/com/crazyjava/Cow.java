package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:07
 * Description:
 */
public class Cow {
    private double weight;

    public Cow(){}

    public Cow(double weight){
        this.weight = weight;
    }

    private class CowLeg{
        private double length;
        private String color;

        public CowLeg(){}

        public CowLeg(double length, String color){
            this.length = length;
            this.color = color;
        }

        public double getLength() {
            return length;
        }

        public String getColor() {
            return color;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void info(){
            System.out.println("当前牛腿的颜色是：" + color + "，高:" + length);
            //访问外部成员变量
            System.out.println("本牛腿所在的奶牛重量：" + weight);
        }
    }

    public void test(){
        CowLeg c1 = new CowLeg(1.12, "黑白相间");
        c1.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(378.9);
        cow.test();
    }
}
