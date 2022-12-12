package com.leetcode.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 24点游戏算法
 */
public class TwnteenGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] numstr = str.split(" ");
            int[] nums = new int[4]; // 存放数字
            int[] visit = new int[4]; // 存放对应位置数字的使用状态（1代表已使用）
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                nums[i] = Integer.parseInt(numstr[i]); // 读取数字
            }
            for (int i = 0; i < 4; i++) {
                visit[i] = 1; // 把当前数字标记为已使用
                if (dfs(nums, visit, nums[i])) { // 进入递归
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
        }



    }

    public static boolean dfs(int[] nums, int[] visit, int temp) {
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 0) { // 如果是未使用的数字
                visit[i] = 1; // 标记为已使用
                if (dfs(nums, visit, temp+nums[i]) // 递归判断
                        || dfs(nums, visit, temp-nums[i])
                        || dfs(nums, visit, temp*nums[i])
                        || (temp%nums[i] == 0 && dfs(nums, visit, temp/nums[i]))) {
                    // 如果存在满足条件的，终止循环
                    return true;
                }
                // 不存在满足条件的，说明当前的数字顺序不符要求，进行回溯，把标记重置为0
                visit[i] = 0;
            }
        }
        // 数字都已使用且结果为24，返回真
        if (temp == 24) {
            return true;
        }
        // 不存在24，返回假
        return false;
    }

}
