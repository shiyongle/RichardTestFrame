package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/6 21:40
 * @Description:
 */
public class HashSetR {
    int count;

    public HashSetR(int count){
        this.count = count;
    }

    public String toString(){
        return "R[count:" + count + "]";
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == HashSetR.class){
            HashSetR r = (HashSetR) obj;
            return this.count == r.count;
        }
        return false;
    }

    public int hashCode(){
        return this.count;
    }
}
