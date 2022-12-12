package com.leetcode.huawei;

import java.util.Scanner;

public class IntAndIPRevers {
    private final int N = 4;
    public IntAndIPRevers() {
    }

    public String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        IntAndIPRevers solution = new IntAndIPRevers();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = solution.convert(str);
            System.out.println(res);
        }
    }
}
