package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:28
 * @Description:
 */
public class R implements Comparable{

    int count;

    public R(int count){
        this.count = count;
    }

    public String toString(){
        return "R[count:" + count + "]";
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == R.class){
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object obj) {
        R r = (R) obj;
        return count > r.count ? 1 : count < r.count ? -1 : 0;
    }
}
