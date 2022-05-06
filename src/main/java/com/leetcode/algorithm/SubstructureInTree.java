package com.leetcode.algorithm;

/**
 * @Descriotion 树的字结构
 * @Date 2022/5/6 23:55
 * @Created by shiyl
 */
public class SubstructureInTree {
    public class TreeNode{
        double val;
        TreeNode left = null;
        TreeNode right =null;
        public TreeNode(int val) {
            this.val=val;
        }
    }

    /*
     * 主程序，对每个结点遍历判断
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)
            return false;
        return doesTree1HasTree2(root1, root2)|| hasSubtree(root1.left, root2)
                ||hasSubtree(root1.right, root2);
    }

    /*
     * 判断root结点开始的子树中各个结点是否相同
     */
    private boolean doesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2==null) return true;
        if(root1==null) return false;
        return equal(root1.val, root2.val) && doesTree1HasTree2(root1.left, root2.left)
                && doesTree1HasTree2(root1.right, root2.right);
    }

    /*
     * 判断两个浮点数是否相等
     */
    private boolean equal(double num1,double num2) {
        if(num1-num2<0.0000001 && num1-num2>-0.0000001 )
            return true;
        return false;
    }
}
