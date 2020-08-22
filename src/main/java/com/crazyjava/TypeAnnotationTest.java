package com.crazyjava;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:15
 * @Description:
 **/
@Target(ElementType.TYPE_USE)
@interface Notnull{}
@Notnull
public class TypeAnnotationTest implements Serializable {

    public static void main(@Notnull String[] args) throws FileNotFoundException {
        Object obj = "fkjava.org";

        String str = (@Notnull String) obj;

        Object win = new @Notnull JFrame("疯狂软件");

    }

    public void foo(List<@Notnull String> info){

    }

}
