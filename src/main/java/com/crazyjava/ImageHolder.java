package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/17 19:46
 * @Description:
 **/
public class ImageHolder {

    private int id;

    private String name;

    public ImageHolder(){}

    public ImageHolder(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
