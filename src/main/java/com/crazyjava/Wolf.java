package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/15 0:07
 * @Description:
 */
public class Wolf {

    private Animal a;

    public Wolf(Animal a){
        this.a = a;
    }

    public void breathe(){
        a.breathe();
    }

    public void run(){
        System.out.println("我在地上快速的奔跑··");
    }


    public Wolf(){
//        super("灰太狼", 3);
        System.out.println("Wolf的无参构造器");
    }

    public static void main(String[] args) {
        new Wolf();
    }
}
