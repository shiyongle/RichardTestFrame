package com.leetcode.algorithm;

import java.util.ArrayList;

/**
 * @Descriotion 二叉树中和为某一值的路径
 * @Date 2022/5/7 0:04
 * @Created by shiyl
 */
public class PathInTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void findPath(TreeNode root,int target) {
        if(root==null)
            return;
        ArrayList<Integer> list= new ArrayList<>();
        printPath(root, target,list);
    }

    private void printPath(TreeNode node,int target,ArrayList<Integer> list) {
        if(node==null)
            return;
        list.add(node.val);
        target-=node.val;  //每个结点的target不会受到方法的影响而改变
        if(target==0 && node.left==null && node.right==null) {  //叶子结点
            for (Integer integer : list)
                System.out.print(integer+" ");
            System.out.println();
        }else {     //中间结点
            printPath(node.left, target, list);
            printPath(node.right, target, list);
        }
        list.remove(list.size()-1);
    }
}
