package com.leetcode.query;

/**
 * @Descriotion 旋转数组的最小数字
 * @Date 2022/5/6 20:49
 * @Created by shiyl
 */
public class MinNumberInRotatedArray {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) // 空数组或null时返回0
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        //升序数组
        if (array[low] < array[high])
            return array[low];
        //中间数字与首尾数字相等
        if (array[mid] == array[high] && array[mid] == array[low]) {
            for (int i = 1; i <= high; i++) {
                if (array[i] < array[i - 1])
                    return array[i];
            }
            return array[low];
        }
        //正常情况
        while (low < high) {
            if (high - low == 1)
                break;
            mid = (low + high) / 2;
            if (array[mid] <= array[high])
                high = mid;
            if (array[mid] > array[high])
                low = mid;
        }
        return array[high]; // 别错写成了return high; !!
    }

    // =======测试代码======
    public void test1() {
        int[] array = null;
        System.out.println("test1:" + minNumberInRotateArray(array));
    }

    public void test2() {
        int[] array = {};
        System.out.println("test2:" + minNumberInRotateArray(array));
    }

    public void test3() {
        int[] array = { 1 };
        System.out.println("test3:" + minNumberInRotateArray(array));
    }

    public void test4() {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println("test4:" + minNumberInRotateArray(array));
    }

    public void test5() {
        int[] array = { 2, 2, 2, 2, 1, 2 };
        System.out.println("test5:" + minNumberInRotateArray(array));
    }

    public void test6() {
        int[] array = { 2, 1, 2, 2, 2, 2 };
        System.out.println("test6:" + minNumberInRotateArray(array));
    }

    public void test7() {
        int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
        System.out.println("test7:" + minNumberInRotateArray(array));
    }

    public static void main(String[] args) {
        MinNumberInRotatedArray demo = new MinNumberInRotatedArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
