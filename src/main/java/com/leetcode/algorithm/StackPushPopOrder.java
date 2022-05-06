package com.leetcode.algorithm;

import java.util.Stack;

/**
 * @Descriotion 栈的压入、弹出序列
 * @Date 2022/5/7 0:00
 * @Created by shiyl
 */
public class StackPushPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popA.length!=pushA.length || pushA.length==0)
            return false;
        int popIndex=0;
        for(int pushIndex=0; pushIndex<pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while(!stack.empty() &&stack.peek()==popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
