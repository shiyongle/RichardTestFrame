package com.crazyjava;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Richered
 * @Date: 2020/7/12 22:28
 * @Description:
 */
public class SearchTest {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);

        System.out.println(nums);

        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));

        Collections.replaceAll(nums, 0, 1);
        System.out.println(nums);

        Collections.sort(nums);
        System.out.println(nums);
    }
}
