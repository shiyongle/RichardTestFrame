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

    private String[] divide(double num){
        double zheng = (long)num;
        double xiao = Math.round((num - zheng) * 100);
        return new String[]{zheng + "", String.valueOf(xiao)};
    }

    private String toHanStr(String numStr){
        String result = "";
        int numLen = numStr.length();
        for (int i = 0; i < numLen; i ++){
            int num = numStr.charAt(i) - 48;
            if (i != numLen -1 && num != 0){
                result += hanArr[num] +unitArr[numLen -2 -i];
            }else {
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
