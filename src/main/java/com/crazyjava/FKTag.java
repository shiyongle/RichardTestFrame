package com.crazyjava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:01
 * @Description:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FKTag {

    String name() default "疯狂软件";

    int age();

}
