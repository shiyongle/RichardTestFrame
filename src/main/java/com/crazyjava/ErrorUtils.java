package com.crazyjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Richered
 * @Date: 2020/08/19 16:50
 * @Description:
 **/
public class ErrorUtils {

    public static void faultyMethod(List<String>... listStrArray){
        List[] listarray = listStrArray;
        List<Integer> myList = new ArrayList<>();
        myList.add(new Random().nextInt(100));
        listarray[0] = myList;
        String s = listStrArray[0].get(0);
    }
}
