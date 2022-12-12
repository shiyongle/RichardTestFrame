package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 输出单向链表倒数的第K个节点
 */
public class OutputLinkedList {
    private int size;
    private ListNode head;

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public OutputLinkedList(int size, int[] array) {
        this.size = size;
        this.head = new ListNode(array[0]);

        ListNode p = head;
        for (int i = 1; i < size; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
    }

    public ListNode findKthToTail(int k) {
        // 题目没有指出，无法理解
        if (k == 0) return new ListNode(0);
        if (k < 0 || k > size) return null;
        k = size - k;
        ListNode p = head;
        while (k != 0) {
            p = p.next;
            k--;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.next());
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(in.next());
            }
            int k = Integer.parseInt(in.next());
            OutputLinkedList solution = new OutputLinkedList(n, array);
            ListNode node = solution.findKthToTail(k);
            if (node != null) {
                System.out.println(node.val);
            }
            else {
                System.out.println();
            }
        }
    }
}
