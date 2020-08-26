package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: Richered
 * @Date: 2020/8/27 0:14
 * @Description:
 */
public class TransientTest {

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"))){

            PersonIo per = new PersonIo("孙悟空", 500);
            oos.writeObject(per);
            PersonIo p = (PersonIo)ois.readObject();
            System.out.println(p.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
