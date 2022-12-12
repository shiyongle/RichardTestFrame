package com.leetcode.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符串字符匹配
 */
public class StringToChar {
    public boolean isAllCharExist(String pShortString, String pLongString) {
        Set<Character> set = new HashSet<>();
        for (char ch : pLongString.toCharArray()) {
            set.add(ch);
        }
        for (char ch : pShortString.toCharArray()) {
            if (!set.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringToChar solution = new StringToChar();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pShortString = in.nextLine();
            String pLongString = in.nextLine();
            boolean res = solution.isAllCharExist(pShortString, pLongString);
            System.out.println(res);
        }
    }
}
