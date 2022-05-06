package com.leetcode.algorithm;

/**
 * @Descriotion 反转链表
 * @Date 2022/5/6 23:53
 * @Created by shiyl
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /*
     * 三个指针实现
     */
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode pNode=head;
        ListNode preNode=null;
        ListNode nextNode=pNode.next;
        while(nextNode!=null) {
            pNode.next=preNode;
            preNode=pNode;
            pNode=nextNode;
            nextNode=pNode.next;
        }
        pNode.next=preNode;
        return pNode;
    }

    /*
     * 递归实现
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode rvsHead=reverseList(head.next);
        //找到了最后的头结点后，开始转换每个结点的指向
        head.next.next=head;
        head.next=null;
        return rvsHead;
    }
}
