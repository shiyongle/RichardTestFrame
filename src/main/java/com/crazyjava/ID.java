package com.crazyjava;

import java.lang.annotation.*;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:22
 * @Description:
 **/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ID {

    String column();

    String type();

    String generator();
}
