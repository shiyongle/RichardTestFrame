package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:31
 * @Description:
 */
public class ReferenceTransferTest {
    public static void swap(DataWrap dw){
        int tmp = dw.a;
        dw.a = dw.b;
        dw.b = tmp;
        System.out.println("Swap方法里，a的成员变量是:" + dw.a + "; b成员变量的值是"+ dw.b);
    }

    public static void main(String[] args) {
        DataWrap dw = new DataWrap();
        dw.a = 6;
        dw.b = 9;
        swap(dw);
        System.out.println("交换结束后，a的成员变量是:" + dw.a + "; b成员变量的值是" + dw.b);
    }
}
