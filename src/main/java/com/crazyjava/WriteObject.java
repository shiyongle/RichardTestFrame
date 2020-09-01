package com.crazyjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author: Richered
 * @Date: 2020/08/26 13:37
 * @Description:
 **/
public class WriteObject {

    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))){
            PersonSerializable per = new PersonSerializable("孙悟空", 500);
            oos.writeObject(per);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
