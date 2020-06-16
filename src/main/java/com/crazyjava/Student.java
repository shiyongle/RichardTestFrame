package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:30
 * @Description:
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String email;

    public Student(){}

    public Student(String name, int age, String gender, String phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public void eat(){
        System.out.println("学生正在吃····");
    }

    public void drink(){
        System.out.println("学生正在喝·····");
    }

    public void play(){
        System.out.println("学生正在玩~~~~~");
    }

    public void sleep(){
        System.out.println("学生正在睡······");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 判断名字是否存在
     * @param name
     * @return
     */
    public Boolean isEqualName(String name){
        return this.name.equals(name);
    }

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("张三",20,"男","13216101995","杭州市","richered@yeah.net");
        students[1] = new Student("李四",22,"女","13216101993","杭州市","richered1@yeah.net");
        students[2] = new Student("王五",23,"男","13216101994","杭州市","richered2@yeah.net");
        students[3] = new Student("刘⑥",24,"女","13216101996","杭州市","richered@3yeah.net");
        students[4] = new Student("于七",25,"男","13216101997","杭州市","richered4@yeah.net");

        String name = "李四";
        boolean isFind = false;
        for (Student student : students){
            if (student.isEqualName(name)){
                isFind = true;
            }
        }
        if (isFind){
            System.out.println("找到" + name + "!");
        }else {
            System.out.println("查无此人");
        }
    }
}
