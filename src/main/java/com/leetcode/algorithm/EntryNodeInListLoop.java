package com.leetcode.algorithm;

/**
 * @Descriotion 链表中环的入口节点
 * @Date 2022/5/6 23:52
 * @Created by shiyl
 */
public class EntryNodeInListLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * 确定链表是否有环，采用快慢指针确定
     * 返回值代表快慢指针相遇时的结点，返回null代表链表无环
     */
    private ListNode meetingNode(ListNode head) {
        if(head==null)
            return null;
        ListNode pSlow=head;
        ListNode pFast=head;
        while(pFast!=null) {
            pSlow=pSlow.next;
            pFast=pFast.next;
            if(pFast!=null)
                pFast=pFast.next;
            if(pSlow!=null && pSlow==pFast)
                return pSlow;
        }
        return null;
    }


    /**
     * 计算环中入口结点
     */
    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode=meetingNode(head);
        if(meetingNode==null)
            return null;

        //计算环中结点的数目
        int count=1;  //环中结点的数目
        ListNode pNode1 = meetingNode.next;
        while(pNode1!=meetingNode){
            count++;
            pNode1=pNode1.next;
        }

        //先移动pNode1，次数为count
        pNode1=head;
        for(int i=1;i<=count;i++) {
            pNode1=pNode1.next;
        }
        ListNode pNode2=head;
        while(pNode1!=pNode2) {
            pNode1=pNode1.next;
            pNode2=pNode2.next;
        }
        return pNode1;
    }
}
