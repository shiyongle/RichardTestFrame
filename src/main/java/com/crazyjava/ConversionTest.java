package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/15 14:27
 * Description:
 */
public class ConversionTest {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long)d;
        System.out.println(l);

        int in = 5;
//        boolean b = (boolean) in;  类型转换异常，数值类型的变量不能转换为boolean

        Object obj = "Hello";
        //obj与String存在继承关系，因此可以转换
        String objstr = (String) obj;
        System.out.println(objstr);

        Object objPri = Integer.valueOf(5);
        //objPri变量编译时的类型为Object，实际类型为Integer
        //object与Integer存在继承关系，因此不报错,可以进行强制转换
        //而objPri的实际类型为Integer，因此运行的时候还是回发生castException的异常
        if (objPri instanceof String){
            String str = (String) objPri;
            System.out.println(str);
        }
    }
}
