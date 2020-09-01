package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: Richered
 * @Date: 2020/08/26 15:35
 * @Description:
 **/
public class SerializeMutable {

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt"))){
            PersonSerializable per = new PersonSerializable("孙悟空", 500);
            oos.writeObject(per);
            per.setName("猪八戒");
            oos.writeObject(per);
            PersonSerializable p1 = (PersonSerializable)ois.readObject();
            PersonSerializable p2 = (PersonSerializable)ois.readObject();
            System.out.println(p1 == p2);
            System.out.println(p2.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
