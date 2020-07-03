package com.crazyjava;

import net.sf.cglib.core.Local;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: Richered
 * @Date: 2020/7/3 16:16
 * Description:
 */
public class LocaleList {
    public static void main(String[] args) {
        Locale[] localeList = Locale.getAvailableLocales();

        for (int i = 0; i < localeList.length; i++){
            System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry() + " " + localeList[i].getDisplayLanguage() + "=" + localeList[i].getLanguage());
        }


        Locale mylocale = Locale.getDefault(Locale.Category.FORMAT);

        ResourceBundle bundle = ResourceBundle.getBundle("mess", mylocale);

        System.out.println(bundle.getString("hello"));
    }
}
