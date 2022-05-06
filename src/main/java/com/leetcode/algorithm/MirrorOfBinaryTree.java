package com.leetcode.algorithm;

/**
 * @Descriotion 二叉树的镜像
 * @Date 2022/5/6 23:56
 * @Created by shiyl
 */
public class MirrorOfBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        //左右子结点交换
        TreeNode tempNode = root.left;
        root.left=root.right;
        root.right=tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }
}
