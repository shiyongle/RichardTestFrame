package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 21:57
 * @Description:
 */
public abstract class SpeedMeter {
    //转速
    private double turnRate;

    public SpeedMeter(){
    }

    public abstract double calGirth();

    public void setTurnRate(double turnRate){
        this.turnRate = turnRate;
    }

    //定义计算速度的通用算法
    public double getSpeed(){
        //速度 = 周长 * 转速
        return calGirth() * turnRate;
    }
}
