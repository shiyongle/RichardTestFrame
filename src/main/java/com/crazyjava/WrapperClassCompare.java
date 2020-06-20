package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/20 15:37
 * Description:
 */
public class WrapperClassCompare {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(6);
        System.out.println("6的包装类是否大于5.0 : " + (a > 5.0));
        System.out.println("比较2个包装类是否相等：" + (Integer.valueOf(2) == Integer.valueOf(2)));

        Integer ina = 2;
        Integer inb = 2;
        System.out.println("两个2自动装箱后是否相等 : " + (ina == inb));       //true

        Integer bna = 128;
        Integer bnb = 128;
        System.out.println("两个128自动装箱后是否相等 : " + (bna == bnb));     //false

        System.out.println(Boolean.compare(true, false));
    }

    //上方128不相等的原因，缓存的原因
    static final Integer[] cache = new Integer[-(128) + 127 + 1];
    static {
        for (int i = 0; i < cache.length; i++){
            cache[i] = new Integer(i - 128);
        }
    }
}
