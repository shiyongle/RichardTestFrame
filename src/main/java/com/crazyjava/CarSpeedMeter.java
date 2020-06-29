package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 22:02
 * @Description:
 */
public class CarSpeedMeter extends SpeedMeter {

    private double radius;

    public CarSpeedMeter(double radius){
        this.radius = radius;
    }

    @Override
    public double calGirth() {
        return radius * 2 * Math.PI;
    }

    public static void main(String[] args) {
        CarSpeedMeter csm = new CarSpeedMeter(0.34);
        csm.setTurnRate(15);
        System.out.println(csm.getSpeed());
    }
}
