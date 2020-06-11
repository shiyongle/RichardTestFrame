package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/12 0:22
 * @Description:
 */
public class ContructorOverloadTest {
    public String name;
    public int count;

    public ContructorOverloadTest(){
    }

    public ContructorOverloadTest(String name, int count){
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        ContructorOverloadTest cot = new ContructorOverloadTest();
        ContructorOverloadTest cot1 = new ContructorOverloadTest("疯狂java讲义", 20);
        System.out.println(cot.name + "" + cot.count);
        System.out.println(cot1.name + "" + cot1.count);

    }
}
