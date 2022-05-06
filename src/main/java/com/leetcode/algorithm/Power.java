package com.leetcode.algorithm;

/**
 * @Descriotion 数值的整数次方
 * @Date 2022/5/6 22:54
 * @Created by shiyl
 */
public class Power {
    boolean IsInvalid = false;//用全局变量标记是否出错

    public double power(double base, int exponent) {
        IsInvalid = false;
        double result; // double类型
        if (exponent > 0) {
            result = powerCore(base, exponent);
        } else if (exponent < 0) {
            if (base == 0) {
                IsInvalid = true; //0的负数次方不存在
                return 0;
            }
            result = 1 / powerCore(base, -exponent);
        } else {
            return 1; //这里0的0次方输出为1
        }
        return result;
    }

    private double powerCore(double base, int exponent) {
        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;
        double result = powerCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    // ========测试代码========
    void test(String testName, double base, int exponent, double expected, boolean expectedFlag) {
        if (testName != null)
            System.out.print(testName + ":");
        if (power(base, exponent) == expected && IsInvalid == expectedFlag) {
            System.out.println("passed.");
        } else {
            System.out.println("failed.");
        }
    }

    void test1() {
        test("test1", 0, 6, 0, false);
    }

    void test2() {
        test("test2", 0, -6, 0, true);
    }

    void test3() {
        test("test3", 0, 0, 1, false);
    }

    void test4() {
        test("test4", 2, 6, 64, false);
    }

    void test5() {
        test("test5", 2, -3, 0.125, false);
    }

    void test6() {
        test("test6", 5, 0, 1, false);
    }

    void test7() {
        test("test7", -2, 6, 64, false);
    }

    public static void main(String[] args) {
        Power demo = new Power();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
