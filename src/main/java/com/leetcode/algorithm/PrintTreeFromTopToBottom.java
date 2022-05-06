package com.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Descriotion 从上往下打印二叉树
 * @Date 2022/5/7 0:01
 * @Created by shiyl
 */
public class PrintTreeFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /*
     *  不分行从上往下打印二叉树
     */
    // 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
    public void printTree1(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (queue.size()!=0) {
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        System.out.println();
    }

    /*
     * 分行从上到下打印二叉树
     */
    // 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
    // 打印到一行。
    public void printTree2(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            //打印当前层数字，并计算下一层结点数目
            for (int i = 1; i <= pCount; i++) {
                node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }

    /*
     * 之字形打印二叉树
     */
    // 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
    // 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
    // 其他行以此类推。
    /**
     * 自己开始想的方法，采用数组存储每层的数字，根据当前层数确定正反向打印数组
     */
    public void printTree3_1(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        int level=1;    //层数
        int[] pNums=null;    //用于存储当前层的数字
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            pNums=new int[pCount];
            //存储当前层数字，并计算下一层结点数目
            for (int i = 0; i < pCount; i++) {
                node = queue.poll();
                pNums[i]=node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            //根据当前层数确定正向或者反向打印数组
            if((level&1)!=0 ) {
                for(int i=0;i<pCount;i++) {
                    System.out.print(pNums[i]+" ");
                }
            }else {
                for(int i=pCount-1;i>=0;i--) {
                    System.out.print(pNums[i]+" ");
                }
            }
            level++;
            System.out.println();
        }
    }

    /**
     * 采用两个栈进行操作的方法
     */
    public void printTree3_2(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = null;
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()) {
            while(!stack1.empty()) {
                node=stack1.pop();
                System.out.print(node.val + " ");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);
            }
            System.out.println();
            while(!stack2.empty()) {
                node=stack2.pop();
                System.out.print(node.val + " ");
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            System.out.println();
        }
    }

    //============测试代码==============
    private void test(int testNum,TreeNode root) {
        System.out.println("=========test"+testNum+"===========");
        System.out.println("method1:");
        printTree1(root);
        System.out.println("method2:");
        printTree2(root);
        System.out.println("method3_1:");
        printTree3_1(root);
        System.out.println("method3_2:");
        printTree3_2(root);
    }

    //null
    private void test1() {
        TreeNode node=null;
        test(1, node);
    }

    //单个结点
    private void test2() {
        TreeNode node=new TreeNode(1);
        test(2, node);
    }

    //左斜
    private void test3() {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node2.left=node3;
        test(3, node1);
    }

    //右斜
    private void test4() {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.right=node3;
        test(4, node1);
    }

    //完全二叉树
    private void test5() {
        TreeNode[] nodes = new TreeNode[15];
        for(int i=0;i<15;i++) {
            nodes[i]= new TreeNode(i+1);
        }
        for(int i=0;i<7;i++) {
            nodes[i].left=nodes[2*i+1];
            nodes[i].right=nodes[2*i+2];
        }
        test(5, nodes[0]);
    }

    public static void main(String[] args) {
        PrintTreeFromTopToBottom demo= new PrintTreeFromTopToBottom();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
    }
}
