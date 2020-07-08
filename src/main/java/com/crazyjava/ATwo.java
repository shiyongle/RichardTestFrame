package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:44
 * @Description:
 */
public class ATwo {
    int count;
    public ATwo(int count){
        this.count = count;
    }

    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (obj != null && obj.getClass() == ATwo.class){
            ATwo a = (ATwo) obj;
            return this.count == a.count;
        }
        return false;
    }

    public int hashCode(){
        return this.count;
    }
}
