package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:45
 * @Description:
 */
public class MultiException {
    public static void main(String[] args) {
        try {
            Integer a = Integer.parseInt(args[0]);
            Integer b = Integer.parseInt(args[1]);
            Integer c = a / b;
            System.out.println("您输入的两个数相除的结果是：" +c);
        }catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException ie){
            System.out.println("程序发生了数组越界异常、数字格式异常、算术异常之一");
//            ie = new ArithmeticException("test");
        }catch (Exception e){
            System.out.println("未知异常");
        }
    }
}
