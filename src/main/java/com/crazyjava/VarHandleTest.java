package com.crazyjava;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/7/3 15:43
 * Description:
 */
public class VarHandleTest {
    public static void main(String[] args) throws Throwable{
        String[] sa = new String[]{"Java", "Kotlin", "Go"};

        VarHandle avh = MethodHandles.arrayElementVarHandle(String[].class);

        boolean r = avh.compareAndSet(sa, 2, "Go", "Lua");

        System.out.println(r);

        System.out.println(Arrays.toString(sa));

        System.out.println(avh.get(sa, 1));

        System.out.println(avh.getAndSet(sa, 2, "swift"));

        System.out.println(Arrays.toString(sa));

        VarHandle vh1 = MethodHandles.lookup().findVarHandle(UserOne.class, "name", String.class);

        UserOne userOne = new UserOne();

        System.out.println(vh1.get(userOne));

        vh1.set(userOne, "孙悟空");

        System.out.println(userOne.name);

        VarHandle vh2 = MethodHandles.lookup().findStaticVarHandle(UserOne.class, "MAX_AGE", int.class);

        System.out.println(vh2.get());

        vh2.set(100);

        System.out.println(UserOne.MAX_AGE);
    }
}
