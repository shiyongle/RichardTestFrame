package com.leetcode.query;

/**
 * @Descriotion 在O(1)时间删除链表节点
 * @Date 2022/5/6 23:45
 * @Created by shiyl
 */
public class DeleteNodeInList {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int value,ListNode nextNode) {
            val=value;
            next=nextNode;
        }
    }

    /**
     * 返回值：头结点
     * 返回值不可以为void，否则头结点无法删除
     * 即：函数中虽然令head=null，但返回到主程序后，
     * head还是不变，所以令该函数返回值为ListNode
     */
    public ListNode deleteNode(ListNode head,ListNode pToBeDeleted) {
        if(head==null||pToBeDeleted==null)
            return head;
        //待删除结点不是尾结点
        if(pToBeDeleted.next!=null) {
            ListNode nextNode=pToBeDeleted.next;
            pToBeDeleted.val=nextNode.val;
            pToBeDeleted.next=nextNode.next;
            nextNode=null;
            //只有一个结点（即是尾结点，又是头结点）
        }else if(head==pToBeDeleted) {
            pToBeDeleted=null;
            head=null;
            //链表含多个结点，删除尾结点
        }else {
            ListNode preNode=head;
            while(preNode.next!=pToBeDeleted && preNode!=null) {
                preNode=preNode.next;
            }
            if(preNode==null) {
                System.out.println("无法找到待删除结点！");
                return head;
            }
            preNode.next=null;
            pToBeDeleted=null;
        }
        return head;
    }

    //=========测试代码==========
    void test(ListNode head,ListNode PToBeDelete) {
        System.out.println("============");
        System.out.print("The original list is: ");
        ListNode curr=head;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }

        System.out.print("The node to be deleted is: ");
        if(PToBeDelete!=null)
            System.out.println(PToBeDelete.val);
        else
            System.out.println();

        curr=deleteNode(head, PToBeDelete);
        System.out.print("The result list is: ");
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        System.out.println("============");
    }

    /**
     * 链表含多个结点，删除头结点
     */
    void test1() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p1);
    }

    /**
     * 链表含多个结点，删除中间结点
     */
    void test2() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p3);
    }

    /**
     * 链表含多个结点，删除尾结点
     */
    void test3() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p4);
    }

    /**
     * 链表含一个结点，删除结点
     */
    void test4() {
        ListNode p4=new ListNode(4, null);
        test(p4, p4);
    }

    /**
     * 链表为空
     */
    void test5() {
        test(null, null);
    }

    public static void main(String[] args) {
        DeleteNodeInList demo = new DeleteNodeInList();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
    }
}
