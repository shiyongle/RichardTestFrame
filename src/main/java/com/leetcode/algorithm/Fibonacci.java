package com.leetcode.algorithm;

/**
 * @Descriotion 斐波那契数列以及青蛙跳台阶问题
 * @Date 2022/5/6 20:47
 * @Created by shiyl
 */
public class Fibonacci {
    public long Fib(long n) {
        if(n<0)
            throw new RuntimeException("下标错误，应从0开始！");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long prePre = 0;
        long pre = 1;
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    //附：缩略版（考虑到代码的可读性，其实还是上面的方法比较好）
    public long Fib2(long n) {
        if(n<0)
            throw new RuntimeException("下标错误，应从0开始！");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long pre = 0;
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result += pre;
            pre = result - pre;
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci demo = new Fibonacci();
        System.out.println(demo.Fib(0));
        System.out.println(demo.Fib(1));
        System.out.println(demo.Fib(2));
        System.out.println(demo.Fib(8));
        System.out.println(demo.Fib(50));
        System.out.println(demo.Fib(100));
        System.out.println(demo.Fib(-5));
    }
}
