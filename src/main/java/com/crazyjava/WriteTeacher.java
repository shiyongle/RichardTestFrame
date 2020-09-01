package com.crazyjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author: Richered
 * @Date: 2020/08/26 15:28
 * @Description:
 **/
public class WriteTeacher {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))){
            PersonSerializable per = new PersonSerializable("孙悟空", 500);
            TeacherSerializable t1 = new TeacherSerializable("唐僧", per);
            TeacherSerializable t2 = new TeacherSerializable("菩提祖师", per);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
