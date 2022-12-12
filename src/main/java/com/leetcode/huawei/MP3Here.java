package com.leetcode.huawei;

import java.util.Scanner;

/**
 * MP3光标的位置
 */
public class MP3Here {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String cmd = sc.next();
            parseCmd(cmd, n);
        }
    }

    public static void parseCmd(String str, int n) {
        // 页面数据大小，默认4
        int pageSize = 4;
        // 页面的歌曲大小，最大为4
        if (n < pageSize) {
            pageSize = n;
        }
        // 根据指令移动current光标，可以当作歌曲编号
        int current = 1;
        // 记录光标在页面中的位置pageIndex，即歌曲编号
        int pageIndex = 1;
        for (int i=0; i < str.length(); i++) {
            // 上移
            if (str.charAt(i) == 'U') {
                // 特殊情况，当前光标在歌曲中第一首
                if (current == 1) {
                    // 从第一行上移，移动到最后的歌曲
                    current = n;
                    // 光标在页面的位置，
                    pageIndex = pageSize;
                    // 一般情况，即光标不在第一行
                } else {
                    // 光标上移
                    current--;
                    if (pageIndex != 1) {
                        pageIndex--;
                    }
                }
            } else {
                // 下移
                // 已经到最后一首歌曲，光标到第一首歌曲
                if (current == n) {
                    current = 1;
                    pageIndex = 1;
                } else {
                    // 非最后一行，则光标下移即可
                    current++;
                    if (pageIndex != pageSize) {
                        pageIndex++;
                    }
                }
            }
        }
        // 计算光标前后数字个数
        int next =  pageSize - pageIndex;
        int pre = pageSize - 1 - next;
        // 打印页面
        String page = "";
        // 从当前光标前一个元素开始向前打印
        for (int i = pre; i>0; i--) {
            page += (current-i) + " ";
        }
        page += current + " ";
        for (int i=1; i<=next; i++) {
            page += (current + i) + " ";
        }
        // 去除尾部空格
        page = page.substring(0, page.length()-1);
        System.out.println(page);
        // 打印当前光标
        System.out.println(current);
    }
}
