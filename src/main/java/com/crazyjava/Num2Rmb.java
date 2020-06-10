package com.crazyjava;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:51
 * @Description: 人民币转换为大写，数组实现
 */
public class Num2Rmb {
    private String[] hanArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] unitArr = {"十", "百","千"};

    /**
     * 把浮点数分解成整数和小数字符串
     * @param num 需要被分解的浮点数
     * @return 分解出来的整数部分和小数部分。第一个数组元素是整数部分，第二个数组元素是小数部分
     */
    private String[] divide(double num){
        //强转为long，得到他的整数
        double zheng = (long)num;
        //浮点数减去整数，得到小数部分，小数部分乘以100后再取整得到2位小数
        double xiao = Math.round((num - zheng) * 100);
        return new String[]{zheng + "", String.valueOf(xiao)};
    }

    /**
     * 把四位的数字字符串变成汉字字符串
     * @param numStr 需要被转换的四位的数字字符串
     * @return 返回转换的汉化字符串
     */
    private String toHanStr(String numStr){
        String result = "";
        int numLen = numStr.length();
        //依次遍历数字字符串的每一位数字
        for (int i = 0; i < numLen; i ++){
            //把char型数字转换为int型数字，因为他们的ASCII码恰好相差48
            //因此把char型数字减去48得到的int型数字，例如‘4’转换为4
            int num = numStr.charAt(i) - 48;
            //如果不是最后一位数字，而且数字不是0，则需要添加单位千、百、十
            if (i != numLen -1 && num != 0){
                result += hanArr[num] +unitArr[numLen -2 -i];
            }else {     //否则不要添加单位
                result += hanArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Num2Rmb nr = new Num2Rmb();
        System.out.println(Arrays.toString(nr.divide(26455554.123)));
        System.out.println(nr.toHanStr("6189"));
    }
}
