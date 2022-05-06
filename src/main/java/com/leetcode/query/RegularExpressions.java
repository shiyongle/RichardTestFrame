package com.leetcode.query;

/**
 * @Descriotion 正则表达式匹配
 * @Date 2022/5/6 23:47
 * @Created by shiyl
 */
public class RegularExpressions {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int indexOfStr, char[] pattern, int indexOfPattern) {
        if (indexOfStr == str.length && indexOfPattern == pattern.length)
            return true;
        if (indexOfStr < str.length && indexOfPattern == pattern.length)
            return false;
        if (indexOfPattern + 1 < pattern.length && pattern[indexOfPattern + 1] == '*') {
            if ((indexOfStr < str.length && pattern[indexOfPattern] == '.')
                    || (indexOfStr < str.length && pattern[indexOfPattern] == str[indexOfStr])) {
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2)
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern)
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2);
            } else {
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2);
            }
        }
        if (indexOfStr < str.length && (pattern[indexOfPattern] == str[indexOfStr] || pattern[indexOfPattern] == '.'))
            return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 1);
        return false;
    }

    // ==========测试代码=========
    void test(String testName, char[] str, char[] pattern, boolean expected) {
        System.out.print(testName + ":");
        if (match(str, pattern) == expected)
            System.out.println("passed!");
        else
            System.out.println("failed!");
    }

    void test1() {
        char[] str = {};
        char[] pattern = { '.' };
        test("test1", str, pattern, false);
    }

    void test2() {
        char[] str = {};
        char[] pattern = { '.', '*' };
        test("test2", str, pattern, true);
    }

    void test3() {
        char[] str = { 'a' };
        char[] pattern = { '.', '*' };
        test("test3", str, pattern, true);
    }

    void test4() {
        char[] str = {};
        char[] pattern = {};
        test("test4", str, pattern, true);
    }

    void test5() {
        char[] str = null;
        char[] pattern = null;
        test("test5", str, pattern, false);
    }

    void test6() {
        char[] str = { 'a', 'b', 'b' };
        char[] pattern = { 'a', 'b', 'b', '*', 'b' };
        test("test6", str, pattern, true);
    }

    void test7() {
        char[] str = { 'a' };
        char[] pattern = { 'a', 'a', '*' };
        test("test7", str, pattern, true);
    }

    public static void main(String[] args) {
        RegularExpressions demo = new RegularExpressions();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
