package com.crazyjava;

import java.util.ListResourceBundle;
import java.util.Objects;

/**
 * @Author: Richered
 * @Date: 2020/7/3 16:27
 * Description:
 */
public class myMess_zh_CN extends ListResourceBundle {

    //定义资源
    private final Object myData[][] = {
            {"msg", "{0}, 你好！今天的日期是{1}"}
    };

    //重写
    public Object[][] getContents(){
        return myData;
    }
}
