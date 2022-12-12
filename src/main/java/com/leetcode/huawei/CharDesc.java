package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 字符逆序
 */
public class CharDesc {
    private String reverse(String str) {
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }

    public CharDesc() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = reverse(str);
            System.out.println(res);
        }
    }

    public static void main(String[] args)
    {
        CharDesc solution = new CharDesc();
    }
}
