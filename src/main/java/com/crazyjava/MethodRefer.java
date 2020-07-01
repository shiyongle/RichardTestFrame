package com.crazyjava;

import javax.swing.*;

/**
 * @Author: Richered
 * @Date: 2020/7/1 14:59
 * Description:
 */
public class MethodRefer {
    public static void main(String[] args) {
        Converter converter = from -> Integer.valueOf(from);
        Integer val = converter.convert("99");
        System.out.println(val);

        /**
         * 方法引用代替lambda表达式：引用类方法
         * 函数式接口中被实现方法的全部参数传给该方法作为参数
         */
        Converter converter1 = Integer::valueOf;
        System.out.println(converter1.convert("22"));

        /**
         * 创建Converter对象
         */
        Converter converter2 = from -> "fkit.org".indexOf(from);
        Integer value = converter2.convert("it");
        System.out.println(value);

        Converter converter3 = "fkit.org"::indexOf;

        /**
         * 创建MyTest对象
         */
        MyTest mt = (a, b, c) -> a.substring(b, c);
        String str = mt.test("java i love you", 2, 9);
        System.out.println(str);

        MyTest mt1 = String::substring;
        String str1 = mt1.test("java i love you", 2, 9);
        System.out.println(str1);

        /**
         * 引用构造器
         */
        YourTest yt = a -> new JFrame(a);
        JFrame jf = yt.win("我的窗口");
        System.out.println(jf);

        YourTest yt1 = JFrame::new;
    }
}
