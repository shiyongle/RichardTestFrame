package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 查找组成一个偶数最接近的两个素数
 */
public class SelectSuShu {
    public SelectSuShu() {
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= num/i; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int count(int n) {
        int i = n/2, j = n - i;
        while (!isPrime(i) || !isPrime(j)) {
            i++;
            j--;
        }
        return j;
    }

    public static void main(String[] args) {
        SelectSuShu solution = new SelectSuShu();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int res = solution.count(n);
            System.out.println(res);
            System.out.println(n - res);
        }
    }
}
