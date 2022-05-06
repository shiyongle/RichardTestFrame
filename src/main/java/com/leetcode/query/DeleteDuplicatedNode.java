package com.leetcode.query;

/**
 * @Descriotion 删除链表中重复的节点
 * @Date 2022/5/6 23:46
 * @Created by shiyl
 */
public class DeleteDuplicatedNode {
    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next=next;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null) //空结点或者仅一个结点
            return pHead;
        ListNode preNode = null;
        ListNode curNode = pHead;

        while(curNode!=null){
            boolean needDelete=false;
            if(curNode.next!=null && curNode.val==curNode.next.val)
                needDelete=true;
            if(!needDelete){  //当前结点不重复
                preNode=curNode;
                curNode=curNode.next;
            }else{            //当前结点重复
                int dupValue=curNode.val;
                ListNode toBeDel = curNode;
                while(toBeDel!=null&&toBeDel.val==dupValue){
                    //这里删除暂时不涉及前一结点操作，其实主要是找出后面第一个不重复结点
                    toBeDel = toBeDel.next;
                }
                if(preNode==null){  //说明删除的结点为头结点
                    pHead=toBeDel;
                }else{
                    preNode.next=toBeDel;
                }
                curNode=toBeDel;  //这个结点还是可能会出现重复的，所以不能=next
            }
        }
        return pHead;
    }


    //========测试代码======
    void test(ListNode pHead) {
        System.out.println("-----------");
        System.out.print("The original list is: ");
        ListNode curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        pHead=deleteDuplication(pHead);
        System.out.print("The result list is: ");
        curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        System.out.println("-----------");
    }


    /**
     * 重复结点位于链表头部
     */
    void test1() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表尾部
     */
    void test2() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表中部
     */
    void test3() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 连续出现重复结点
     */
    void test4() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(2, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 多个重复结点
     */
    void test5() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(3, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 无重复结点
     */
    void test6() {
        ListNode p6=new ListNode(6, null);
        ListNode p5=new ListNode(5, p6);
        ListNode p4=new ListNode(4, p5);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 单个结点
     */
    void test7() {
        ListNode p1=new ListNode(6, null);
        test(p1);
    }

    /**
     * null
     */
    void test8() {
        ListNode p1=null;
        test(p1);
    }

    public static void main(String[] args) {
        DeleteDuplicatedNode demo= new DeleteDuplicatedNode();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
    }
}
