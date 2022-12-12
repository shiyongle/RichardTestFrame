package com.leetcode.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 句子逆序
 */
public class SentenceReverseOrder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<String> words = new LinkedList<>();
        for (String word : scanner.nextLine().split("\\s+")) {
            words.addFirst(word);
        }
        System.out.println(String.join(" ", words));
    }
}
