package com.crazyjava;

import java.lang.ref.WeakReference;

/**
 * @Author: Richered
 * @Date: 2020/7/1 17:44
 * Description:
 */
public class ReferenceTest {
    public static void main(String[] args) throws Exception{
        String str = new String("疯狂java讲义");
        WeakReference wr = new WeakReference(str);
        str = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }
}
