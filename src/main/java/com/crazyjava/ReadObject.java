package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: Richered
 * @Date: 2020/08/26 13:39
 * @Description:
 **/
public class ReadObject {

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj,txt"))){
            PersonSerializable p = (PersonSerializable)ois.readObject();
            System.out.println("名字为:" + p.getName() + "\n年龄为:" + p.getAge());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
