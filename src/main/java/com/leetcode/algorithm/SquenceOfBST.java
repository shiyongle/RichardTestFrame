package com.leetcode.algorithm;

/**
 * @Descriotion 二叉搜索树的后序遍历序列
 * @Date 2022/5/7 0:02
 * @Created by shiyl
 */
public class SquenceOfBST {
    public boolean  verifySquenceOfBST(int[] sequence) {
        if(sequence== null || sequence.length<=0)
            return false;
        return verifyCore(sequence, 0, sequence.length-1);
    }

    private boolean verifyCore(int[] sequence,int start,int end) {
        if(start>=end)
            return true;
        //判断左子树
        int mid=start;
        while(sequence[mid]<sequence[end])
            mid++;
        //判断右子树
        for(int i=mid;i<end;i++) {
            if(sequence[i]<sequence[end])
                return false;
        }
        return verifyCore(sequence, start, mid-1)&&verifyCore(sequence, mid, end-1);
    }
}
