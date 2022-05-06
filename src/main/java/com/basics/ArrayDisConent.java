package com.basics;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 *  数组key值获取
 */
public class ArrayDisConent {

    public static void disConent(int[] data){
        Map<Integer, Integer> map = new HashedMap();
        for (Integer i : data){
            map.put(i, i);
        }

        System.out.println(map.keySet());
        System.out.println(map.values());

        for (Integer key : map.keySet()){
            System.out.println("key=" + key + "and value = " + map.get(key));
        }

        int[] temp = new int[map.size()];

        int i = 0;

        for (Integer key : map.keySet()){
            temp[i] = map.get(key);
            i++;
        }

        for (int j = 0; j < temp.length; j++){
            System.out.println(temp[j] + " ");
        }

        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] sun = new int[]{2,2,2,2,2,4,5,6,6,7,7,7,7,7};
        ArrayDisConent.disConent(sun);
    }
}
