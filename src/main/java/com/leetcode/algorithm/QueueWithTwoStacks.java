package com.leetcode.algorithm;

import java.util.Stack;

/**
 * @Descriotion 两个栈实现队列
 * @Date 2022/5/6 20:46
 * @Created by shiyl
 */
public class QueueWithTwoStacks {
    class Queue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        /**
         * 插入结点
         */
        public void push(int node) {
            stack1.push(node);
        }

        /**
         * 删除结点
         */
        public int pop() {
            if (stack2.empty()) {
                if (stack1.empty())
                    throw new RuntimeException("队列为空！");
                else {
                    while (!stack1.empty())
                        stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }


    //=======测试代码==========

    public void test1() {
        Queue queue= new Queue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    /**
     * 往空队列删除元素
     */
    public void test2() {
        Queue queue= new Queue();
        System.out.println(queue.pop());
    }

    public static void main(String[] args) {
        QueueWithTwoStacks demo = new QueueWithTwoStacks();
        demo.test1();
        demo.test2();
    }
}
