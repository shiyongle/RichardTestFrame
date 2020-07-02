package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/2 11:27
 * Description:
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        User user = new User(29);
        User user1 = user.clone();

        System.out.println(user == user1);

        System.out.println(user.addressObject == user1.addressObject);
    }
}
