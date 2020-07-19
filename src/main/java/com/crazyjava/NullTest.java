package com.crazyjava;

import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:42
 * @Description:
 */
public class NullTest {
    public static void main(String[] args) {
        Date d = null;
        try {
            System.out.println(d.after(new Date()));
        }catch (NullPointerException ne){
            System.out.println("空指针异常");
        }catch (Exception e){
            System.out.println("未知异常");
        }
    }
}
