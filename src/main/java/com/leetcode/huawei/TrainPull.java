package com.leetcode.huawei;

import java.util.*;

/**
 * 火车进站
 */
public class TrainPull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            // 未进站的火车
            Queue<Integer> queue = new LinkedList<>();
            // 已进站的火车
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                queue.offer(sc.nextInt());
            }

            List<String> outQueueList = new ArrayList<>();

            // 获取所有出站队列保存到outQueueList
            processOutQueue(queue, stack, "", outQueueList);

            // 排序
            Collections.sort(outQueueList);
            for (String str : outQueueList) {
                System.out.println(str);
            }

        }
    }

    private static void processOutQueue(Queue<Integer> queue, Stack<Integer> stack, String outQueue, List<String> outQueueList) {
        // 如果队列和栈都为空，则保存出站信息
        if (queue.isEmpty() && stack.isEmpty()) {
            outQueueList.add(outQueue.trim());
            return;
        }

        // 队列和栈有两种情况：出栈或进栈
        // 一：出栈
        if (!stack.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            String tempOutQueue = outQueue + (tempStack.pop() + " ");
            processOutQueue(tempQueue, tempStack, tempOutQueue, outQueueList);
        }

        // 二：队列进栈
        if (!queue.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            tempStack.push(tempQueue.poll());
            processOutQueue(tempQueue, tempStack, outQueue, outQueueList);
        }
    }
}
