package com.leetcode.algorithm;

/**
 * @Descriotion 对称的二叉树
 * @Date 2022/5/6 23:58
 * @Created by shiyl
 */
public class SymmetricalBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null)
            return true; //根结点为null时，认为是对称二叉树
        return isEqual(pRoot.left,pRoot.right);
    }

    private boolean isEqual(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null && pRoot2==null)
            return true;
        if(pRoot1==null || pRoot2==null)
            return false;
        return pRoot1.val==pRoot2.val
                && isEqual(pRoot1.left, pRoot2.right)
                && isEqual(pRoot1.right, pRoot2.left);
    }
}
