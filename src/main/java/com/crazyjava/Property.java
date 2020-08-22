package com.crazyjava;

import java.lang.annotation.*;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:31
 * @Description:
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Property {

    String column();

    String type();
}
