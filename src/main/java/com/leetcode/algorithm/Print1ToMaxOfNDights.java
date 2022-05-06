package com.leetcode.algorithm;

/**
 * @Descriotion 打印1到最大的N位数
 * @Date 2022/5/6 22:56
 * @Created by shiyl
 */
public class Print1ToMaxOfNDights {
    //=========方法一============
    /**
     * 采用模拟加一的方法
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        // 不能用foreach方法对nuber[]赋值
        // for (char c : number) {
        // c = '0';
        // }
        for (int k = 0; k < number.length; k++)
            number[k] = '0';
        while (!increment(number)) {
            printCharNumber(number);
        }
    }

    /**
     * 对字符串进行加一操作，number达到最大值后返回true
     * 最低位加一；所有位如果超过10，则进位
     */
    private boolean increment(char[] number) {
        int nTakeOver = 0; // 代表进位
        for (int i = number.length - 1; i >= 0; i--) {
            int nSum = (number[i] - '0') + nTakeOver; // 当前位置数字
            // number[i]-'0'是把char转化为int，nTakeOver代表进位
            if (i == number.length - 1)
                nSum++;
            if (nSum >= 10) {
                if (i == 0)
                    return true; // 超出范围了
                nTakeOver = 1;
                nSum -= 10;
                number[i] = (char) (nSum + '0');
            } else {
                number[i] = (char) (nSum + '0');
                break; // 高位不变，可以直接跳出循环了
            }
        }
        return false;
    }

    /**
     * 打印字符数组形成的数字
     * 书中方法：利用布尔变量isBeginning0来从第一个非零字符打印
     */
    private void printCharNumber(char[] number) {
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBeginning0 && (number[i] - '0') != 0) {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                // System.out.print(number[i] - '0');
                System.out.print(number[i]);
            }
        }
        System.out.println();

    }

    /**
     * 打印字符数组形成的数字
     * 自己的方法：找出第一个非零字符位置，往后进行打印
     */
    private void printCharNumber2(char[] number) {
        int beginner = number.length; // 不写成number.length-1，以防写出0
        for (int i = 0; i <= number.length - 1; i++) {
            if ((number[i] - '0') != 0) {
                beginner = i;
                break;
            }
        }
        for (int i = beginner; i <= number.length - 1; i++) {
            System.out.print(number[i]);
        }
        if (beginner != number.length) // 数字为0时，换行符不输出
            System.out.println();
    }


    //=========方法二============
    /**
     * 采用递归的方法
     */
    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        for (int k = 0; k < number.length; k++)
            number[k] = '0';
        for (int i = 0; i <= 9; i++) {
            makeNumber(n, number, i, 0);
        }
    }

    /**
     * 生成数字
     */
    private void makeNumber(int n, char[] number, int nNumber, int index) {
        if (index == number.length - 1) {
            number[index] = (char) (nNumber + '0');
            printCharNumber2(number); // 打印数字代码与第一个方法一样
            return;
        } else {
            number[index] = (char) (nNumber + '0');
            for (int i = 0; i <= 9; i++) {
                makeNumber(n, number, i, index + 1);
            }
        }
    }

    // ========测试代码=============
    void test(int nDigits) {
        System.out.println("===test begin===");
        System.out.println("method1:");
        print1ToMaxOfNDigits(nDigits);
        System.out.println("method2:");
        print1ToMaxOfNDigits2(nDigits);
        System.out.println("===test over===");
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDights demo = new Print1ToMaxOfNDights();
        demo.test(-1);
        demo.test(0);
        demo.test(1);
        demo.test(2);
    }
}
