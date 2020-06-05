package com.basics;

import java.time.LocalDate;

/**
 * @Author: Richered
 * @Date: 2020/5/28 11:09
 * Description:
 */
public class Employee extends Person{
    private static int nextId = 1;
    private String name;
    private double salary;
    private LocalDate hireDay;
    private int id;

    public Employee(String name, double s, int year, int month, int day) {
        super(name);
        this.salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", id=" + id +
                '}';
    }

    public Employee(String n, double s){
        super(n);
        salary = s;
        id = 0;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of %.2f", salary);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void setId(){
        id = nextId;
        nextId++;
    }

    public static int getNextId(){
        return nextId;
    }

//    public static void main(String[] args) {
//        Employee e =new Employee("Harry", 50000);
//        System.out.println(e.getName() + "" + e.getSalary());
//    }

}
