package com.leetcode.query;

/**
 * @Descriotion 重建二叉树
 * @Date 2022/5/6 20:43
 * @Created by shiyl
 */
public class ConstructBinaryTree {

    class TreeNode {
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode left;
        TreeNode right;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            throw new RuntimeException("数组不符合规范！");
        }
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    /**
     *
     * @Description 由前序遍历序列和中序遍历序列得到根结点
     * pre、in：始终用最初的前序遍历和中序遍历数组代入
     * pStart、pEnd：当前树的前序数组开始和结束位置
     * iStart、iEnd：中序数组开始和结束位置
     */
    public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        TreeNode root = new TreeNode(pre[pStart]);
        if (pStart == pEnd && iStart == iEnd) {
            if (pre[pStart] != in[iStart])
                throw new RuntimeException("数组不符合规范！");
            return root;
        }
        int index = iStart; // 用于记录中序遍历序列中根结点的位置
        while (root.val != in[index] && index <= iEnd) {
            index++;
        }
        if (index > iEnd)
            throw new RuntimeException("数组不符合规范！");
        int leftLength = index - iStart;
        if (leftLength > 0) {
            root.left = construct(pre, in, pStart + 1, pStart + leftLength, iStart, index - 1);
        }
        if (leftLength < iEnd - iStart) {
            root.right = construct(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
        }
        return root;
    }

    private void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }

    /**
     * 正常二叉树
     */
    public void test1() {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test1:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 左斜树
     */
    public void test2() {
        int[] pre = { 1, 2, 3, 4, 5 };
        int[] in = { 5, 4, 3, 2, 1 };
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test2:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 右斜树
     */
    public void test3() {
        int[] pre = { 1, 2, 3, 4, 5 };
        int[] in = { 1, 2, 3, 4, 5 };
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test3:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 单个结点
     */
    public void test4() {
        int[] pre = { 1 };
        int[] in = { 1 };
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test4:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 数组为空
     */
    public void test5() {
        int[] pre = {};
        int[] in = {};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.print("test5:");
        preOrderTraverse(root);
        System.out.print("//");
        inOrderTraverse(root);
        System.out.println();
    }

    public static void main(String[] args) {
        ConstructBinaryTree demo = new ConstructBinaryTree();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
    }
}
