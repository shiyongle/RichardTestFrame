package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:52
 * @Description:
 */
public class FinallyFlowTest {
    public static void main(String[] args) throws Exception{
        boolean a = test();
        System.out.println(a);
    }

    public static boolean test(){
        try {
            return true;
        }finally {
            return false;
        }
    }
}
