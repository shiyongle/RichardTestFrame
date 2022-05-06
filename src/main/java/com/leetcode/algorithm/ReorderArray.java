package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * @Descriotion 调整数组顺序使奇数位于偶数前面
 * @Date 2022/5/6 23:49
 * @Created by shiyl
 */
public class ReorderArray {
    public void reOrderArray(int [] array) {
        if(array==null || array.length==0)
            return;
        int length = array.length;
        int low=0;
        int high=length-1;
        int temp;
        while(low<high){
            //向后移动low指针，直到它指向偶数
            while(low<length && (array[low]&1)!=0)
                low++;
            //向前移动high指针，直到它指向奇数
            while(high>=0 && (array[high]&1)==0)
                high--;
            if(low<high){
                temp=array[low];
                array[low]=array[high];
                array[high]=temp;
            }
        }
    }

    //===============测试代码===================
    void test1() {
        int[] array = null;
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test2() {
        int[] array = {};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test3() {
        int[] array = {-2,4,-6,1,-3,5};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test4() {
        int[] array = {-1,3,-5,2,-4,6};
        System.out.println("原始数组："+ Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test5() {
        int[] array = {-1,2,-3,4,-5,6};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test6() {
        int[] array = {2,2,1,3,4,1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test7() {
        int[] array = {1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderArray demo = new ReorderArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
