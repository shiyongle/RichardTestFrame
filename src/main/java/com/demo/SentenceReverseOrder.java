package com.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SentenceReverseOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> words = new LinkedList<>();
        for (String word : sc.nextLine().split("\\+s")){
            words.addFirst(word);
        }
        System.out.println(String.join("", words));
    }
}
