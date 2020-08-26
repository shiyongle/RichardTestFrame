package com.crazyjava;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/8/27 0:13
 * @Description:
 */
public class PersonIo implements Serializable {

    private String name;

    private transient int age;

    public PersonIo(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out)throws IOException {
        out.writeObject(new StringBuffer(name).reverse());
    }

    private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }

    private Object writeReplace() throws ObjectStreamException{
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(name);
        list.add(age);
        return list;
    }
}
