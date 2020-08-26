package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/8/27 0:23
 * @Description:
 */
public class ReplaceIoTest {

    public static void main(String[] args) {
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("replace.txt"));
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("replace.txt"))){

            PersonIo per = new PersonIo("孙悟空", 500);
            oss.writeObject(per);
            ArrayList list = (ArrayList) ois.readObject();
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
