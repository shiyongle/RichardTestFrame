package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 11:05
 * Description: 循环控制
 */
public class RandomStr {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 6; i++){
            //生成一个97~122之间的int类型整数
            int intValue = (int) (Math.random() * 26 + 97);

            //将intValue强转为char，拼接到result后
            result = result + (char)intValue;
        }

        //输出随机字符串
        System.out.println(result);
    }
}
