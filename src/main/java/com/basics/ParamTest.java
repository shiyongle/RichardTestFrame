package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/5/29 15:52
 * Description: 对象引用例子
 */
public class ParamTest {
    public static void main(String[] args) {
        System.out.println("Testing  tripleValue:");
        double percent = 10;
        System.out.println("Before: percent:" + percent);
        tripleValue(percent);
        System.out.println("After: percent:" + percent);

        System.out.println("\nTesting tripleSalary : ");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before Salary = " + harry.getSalary());
        tripleSalary(harry);

        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before a:" + a.getName());
        System.out.println("Before b:" + b.getName());
        swap(a, b);
        System.out.println("After a:" + a.getName());
        System.out.println("After b:" + b.getName());
    }

    public static void tripleValue(double x){
        x = 3 * x;
        System.out.println("End of method : x = " + x);
    }


    private static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method : x = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method : x = " + x.getName());
        System.out.println("End of method : y = " + y.getName());
    }


}
