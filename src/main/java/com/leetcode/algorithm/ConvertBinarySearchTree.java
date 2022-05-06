package com.leetcode.algorithm;

/**
 * @Descriotion 二叉搜索树与双向链表
 * @Date 2022/5/7 0:06
 * @Created by shiyl
 */
public class ConvertBinarySearchTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode convert(TreeNode head) {
        if(head==null)
            return head;
        TreeNode lastNodeInList=null;
        lastNodeInList=convertHelper(head,lastNodeInList);
        TreeNode firstNodeInList=lastNodeInList;
        while(firstNodeInList.left!=null) {
            firstNodeInList=firstNodeInList.left;
        }
        return firstNodeInList;
    }

    //将以node为根结点的树转化为排序链表，链表头部与lastNode链接，并返回最后一个结点
    private TreeNode convertHelper(TreeNode node,TreeNode lastNode) {
        //处理左子树，获得最大结点
        if(node.left!=null)
            lastNode=convertHelper(node.left, lastNode);
        //链接最大结点和根结点
        node.left=lastNode;
        if(lastNode!=null)
            lastNode.right=node;
        //处理右子树
        lastNode=node;
        if(node.right!=null)
            lastNode=convertHelper(node.right, lastNode);
        return lastNode;
    }
}
