package com.crazyjava;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:55
 * @Description:
 */
public class FinalReferenceTest {
    public static void main(String[] args) {
        final int[] arr = {5,6,12,9};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr[2] = -8;
        System.out.println(Arrays.toString(arr));

        final Person p = new Person(45);
        p.setAge(23);
        System.out.println(p.getAge());
    }
}
