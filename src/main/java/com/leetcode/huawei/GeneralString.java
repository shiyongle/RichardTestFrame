package com.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * 字符串通配符
 */
public class GeneralString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String value;
        while ((value = bf.readLine()) != null) {
            String target = bf.readLine();
            value = value.toLowerCase(Locale.ROOT);
            target = target.toLowerCase(Locale.ROOT);
            String regx = value.replaceAll("\\*{2,}","\\*");
            regx = regx.replaceAll("\\?","[0-9a-z]{1}");
            regx = regx.replaceAll("\\*","[0-9a-z]{0,}");
            System.out.println(target.matches(regx));
        }
    }
}
