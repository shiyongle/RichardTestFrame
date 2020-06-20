package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/17 15:32
 * Description:
 */
public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        //直接把一个基本类型变量赋给Integer对象
        Integer intobj = 5;

        //直接把boolean类型变量赋给一个Object类型的变量
        Object boolObj = true;

        //直接把Integer对象赋给int类型变量
        int it = intobj;

        if (boolObj instanceof Boolean){
            //先把boolObj【object】类型的变量转换为boolean类型，再赋值给boolean的b
            boolean b = (boolean) boolObj;
            System.out.println(b);
        }
    }
}
