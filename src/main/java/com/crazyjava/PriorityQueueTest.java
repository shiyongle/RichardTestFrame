package com.crazyjava;

import java.util.PriorityQueue;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:00
 * @Description:
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        System.out.println(pq);

        System.out.println(pq.poll());
    }
}
