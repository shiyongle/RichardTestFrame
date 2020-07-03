package com.crazyjava;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: Richered
 * @Date: 2020/7/3 16:23
 * Description:
 */
public class HelloArg {
    public static <bundle> void main(String[] args) {
        Locale currentLocale = null;

        if (args.length == 2){
            currentLocale = new Locale(args[0], args[2]);
        }else {
            currentLocale = Locale.getDefault(Locale.Category.FORMAT);
        }

        ResourceBundle bundle = ResourceBundle.getBundle("myMess", currentLocale);

        bundle msg = (bundle) bundle.getString("msg");

        System.out.println(MessageFormat.format((String) msg, "yeeku", new Date()));
    }
}
