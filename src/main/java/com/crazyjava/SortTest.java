package com.crazyjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author: Richered
 * @Date: 2020/7/12 17:14
 * @Description:
 */
public class SortTest {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);

        /**反转**/
        Collections.reverse(nums);
        System.out.println(nums);

        /**自然排序**/
        Collections.sort(nums);
        System.out.println(nums);

        /**随机顺序排列**/
        Collections.shuffle(nums);
        System.out.println(nums);
    }
}
