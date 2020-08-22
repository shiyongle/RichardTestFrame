package com.crazyjava;

import java.lang.annotation.*;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:20
 * @Description:
 **/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Persistent {

    String table();
}
