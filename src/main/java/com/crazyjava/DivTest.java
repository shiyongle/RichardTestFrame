package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 20:55
 * @Description: 算数运算符
 */
public class DivTest {
    public static void main(String[] args) {
        double a = 5.2;
        double b = 3.1;
        double div = a / b;
        System.out.println(div);

        //正无穷
        System.out.println("5除以0.0的结果是：" + 5 / 0.0);

        //报错
//        System.out.println("-5除以0的结果是: " + -5 / 0);

        try {
            Integer c = Integer.parseInt(args[0]);
            Integer d = Integer.parseInt(args[1]);
            Integer e = c / d;
            System.out.println("您输入两个数相除的结果是：" + e);
        }catch (IndexOutOfBoundsException ie){
            System.out.println("数组越界：运行程序时输入的参数个数不够");
        }catch (NumberFormatException ne){
            System.out.println("数字格式化异常：程序只能接收整数参数");
        }catch (ArithmeticException ae){
            System.out.println("算术异常");
        }catch (Exception e){
            System.out.println("未知异常");
        }
    }
}
