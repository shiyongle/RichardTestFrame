package com.callback.service.impl;

import com.callback.service.Callback;
import com.callback.service.Student;

/**
 * @Author: Richered
 * @Date: 2020/1/9 14:39
 * Description:
 */
public class Ricky implements Student {

    @Override
    public void resolveQuestion(Callback callback) {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException  e){
            //告诉老师写了多久；回调
            callback.tellAnswer(3);
        }
    }
}
