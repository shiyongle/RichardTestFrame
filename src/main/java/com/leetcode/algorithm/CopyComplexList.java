package com.leetcode.algorithm;

/**
 * @Descriotion 复杂链表的复制
 * @Date 2022/5/7 0:05
 * @Created by shiyl
 */
public class CopyComplexList {
    public class ComplexListNode {
        int val;
        ComplexListNode next = null;
        ComplexListNode sibling = null;

        ComplexListNode(int label) {
            this.val = label;
        }
    }

    /*
     * 主程序（包含三步）
     */
    public ComplexListNode cloneList(ComplexListNode head) {
        cloneNodes(head);           //1.复制结点
        connectSiblingNodes(head);  //2.设置sibling
        return reconnectNodes(head);//3.拆分长链表
    }

    /*
     * 第一步：复制每个结点，并插入到原始节点的后面
     */
    private void cloneNodes(ComplexListNode head) {
        ComplexListNode pNode=head;
        while(pNode!=null) {
            ComplexListNode clonedNode=new ComplexListNode(pNode.val);
            clonedNode.next=pNode.next;
            pNode.next=clonedNode;
            pNode=clonedNode.next;
        }
    }

    /*
     * 第二步：根据原结点的sibling，设置复制结点的sibling
     */
    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode pNode=head;
        while(pNode!=null) {
            if(pNode.sibling!=null) //必须考虑到siblingNode==null的情况！
                pNode.next.sibling=pNode.sibling.next;
            pNode=pNode.next.next;
        }
    }

    /*
     * 第三步：将长链表拆分成原始链表和复制链表（根据奇偶位置）
     */
    private ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode clonedHead=null;
        ComplexListNode clonedNode=null;
        ComplexListNode pNode=head;
        if(head!=null) {
            clonedHead=head.next;
            clonedNode=pNode.next;
            pNode.next=clonedNode.next;
            pNode=pNode.next;   //提前将pNode指向下一个结点，方便判断是否为null
        }
        while(pNode!=null) {
            clonedNode.next=pNode.next;
            clonedNode=clonedNode.next;
            pNode.next=clonedNode.next;
            pNode=pNode.next;
        }
        return clonedHead;
    }
}
