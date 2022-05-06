package com.leetcode.algorithm;

import java.util.Stack;

/**
 * @Descriotion 包含min函数的栈
 * @Date 2022/5/6 23:59
 * @Created by shiyl
 */
public class StackWithMin {
    Stack<Integer> stack_data=new Stack<Integer>();
    Stack<Integer> stack_min=new Stack<Integer>();

    public void push(int node) {
        stack_data.push(node);
        if(stack_min.empty() || stack_min.peek()>node) {
            stack_min.push(node);
        }else {
            stack_min.push(stack_min.peek());
        }
    }

    public void pop() {
        if(!stack_data.empty()) {
            stack_data.pop();
            stack_min.pop();
        }
    }

    public int min() {
        return stack_min.peek();
    }
}
