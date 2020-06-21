package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:26
 * @Description:
 */
public class PersonTwo {
    private final Name name;
    public PersonTwo(Name name){
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    public Name getName(){
        return new Name(name.getFirstName(), name.getLastName());
    }

    public static void main(String[] args) {
        Name n = new Name("悟空", "孙");
        PersonTwo p = new PersonTwo(n);
        System.out.println(p.getName().getFirstName());
        n.setFirstName("八戒");
        System.out.println(p.getName().getFirstName());
    }
}
