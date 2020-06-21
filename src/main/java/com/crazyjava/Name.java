package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:22
 * @Description:
 */
public class Name {
    private String firstName;
    private String lastName;
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
