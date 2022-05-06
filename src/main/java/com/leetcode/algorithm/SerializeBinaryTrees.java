package com.leetcode.algorithm;

/**
 * @Descriotion 序列化二叉树
 * @Date 2022/5/7 0:07
 * @Created by shiyl
 */
public class SerializeBinaryTrees {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("$,");
        } else {
            sb.append(node.val + ",");
            sb.append(Serialize(node.left));
            sb.append(Serialize(node.right));
        }
        return sb.toString();
    }

    int index = 0;
    TreeNode Deserialize(String str) {
        TreeNode node = null;
        if (str == null || str.length() == 0)
            return node;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            node = new TreeNode(Integer.parseInt(str.substring(start, index)));
            index++; // 这条语句位置别放错了
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        } else {
            index++;
        }
        return node;
    }
}
