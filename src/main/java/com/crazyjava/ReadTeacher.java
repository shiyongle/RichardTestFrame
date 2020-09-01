package com.crazyjava;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * @Author: Richered
 * @Date: 2020/08/26 15:30
 * @Description:
 **/
public class ReadTeacher {

    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))){

            TeacherSerializable t1 = (TeacherSerializable)ois.readObject();
            TeacherSerializable t2 = (TeacherSerializable)ois.readObject();
            PersonSerializable p = (PersonSerializable) ois.readObject();
            TeacherSerializable t3 = (TeacherSerializable) ois.readObject();
            System.out.println("t1的student引用和p是否相同:" + (t1.getStudent() == p));
            System.out.println("t2的student引用和p是否相同:" + (t2.getStudent() == p));
            System.out.println("t2和t3是否是同一个对象:" + (t2 == t3));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
