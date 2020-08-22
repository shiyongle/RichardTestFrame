package com.crazyjava;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @Author: Richered
 * @Date: 2020/08/22 18:50
 * @Description:
 **/
public class ActionListenerInstaller {
    public static void processAnnotations(Object obj){
        try {
            Class cl = obj.getClass();
            for (Field f : cl.getDeclaredFields()){
                f.setAccessible(true);
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                Object fObj = f.get(obj);
                if (a != null && fObj != null && fObj instanceof AbstractButton){
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    ActionListener al = listenerClazz.getDeclaredConstructor().newInstance();
                    AbstractButton ab = (AbstractButton) obj;
                    ab.addActionListener(al);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
