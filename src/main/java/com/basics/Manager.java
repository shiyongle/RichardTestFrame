package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/5/29 16:27
 * Description:
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public Manager(String n, double s) {
        super(n, s);
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
