package com.leetcode.query;

/**
 * @Descriotion 替换空格
 * @Date 2022/5/6 20:37
 * @Created by shiyl
 */
public class ReplaceSpaces {

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            System.out.println("输入错误！");
            return null;
        }
        int length = str.length();
        int indexOfOriginal = length - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                length += 2;
        }
        str.setLength(length);
        int indexOfNew = length - 1;
        while (indexOfNew > indexOfOriginal) {
            if (str.charAt(indexOfOriginal) != ' ') {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            } else {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            indexOfOriginal--;
        }
        return str.toString();
    }

    /**
     * 输入为null
     */
    public void test1() {
        System.out.print("Test1：");
        StringBuffer sBuffer = null;
        String s = replaceSpace(sBuffer);
        System.out.println(s);
    }

    /**
     * 输入为空字符串
     */
    public void test2() {
        System.out.print("Test2：");
        StringBuffer sBuffer = new StringBuffer("");
        String s = replaceSpace(sBuffer);
        System.out.println(s);
    }

    /**
     * 输入字符串无空格
     */
    public void test3() {
        System.out.print("Test3：");
        StringBuffer sBuffer = new StringBuffer("abc");
        String s = replaceSpace(sBuffer);
        System.out.println(s);
    }

    /**
     * 输入字符串为首尾空格，中间连续空格
     */
    public void test4() {
        System.out.print("Test4：");
        StringBuffer sBuffer = new StringBuffer(" a b  c  ");
        String s = replaceSpace(sBuffer);
        System.out.println(s);
    }

    public static void main(String[] args) {
        ReplaceSpaces rs = new ReplaceSpaces();
        rs.test1();
        rs.test2();
        rs.test3();
        rs.test4();
    }
}
