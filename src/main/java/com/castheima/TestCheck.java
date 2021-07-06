package com.castheima;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Richered
 * @Date: 2021/7/5 23:23
 * @Description
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();

        //获取字节码对象
        Class cls = c.getClass();

        //获取所有对象
        Method[] methods = cls.getMethods();

        int number = 0;

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));


        for (Method method : methods){
            //判断对应的方法上是否有注解
            if (method.isAnnotationPresent(Check.class)){
                try {
                    //有的话，执行方法
                    method.invoke(c);
                } catch (Exception e) {
                    number++;
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因" + e.getCause().getMessage());
                    bw.write("-----------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现" + number+  "次异常");
        bw.flush();
        bw.close();
    }
}
