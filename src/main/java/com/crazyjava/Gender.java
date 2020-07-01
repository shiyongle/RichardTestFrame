package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 16:51
 * Description:
 */
public enum Gender implements GenderDesc{
    /**
     * 此处的枚举值必须调用对应的构造器来创建
     */
    MALE("男"){
        public void info(){
            System.out.println("这个枚举值代表男性");
        }
    },
    FEMALE("女"){
        public void info(){
            System.out.println("这个枚举值代表女性");
        }
    };
    private String name;

    private Gender(String name){
        this.name = name;
    }

    public void setName(String name){
        switch (this){
            case MALE:
                if (name.equals("男")){
                    this.name = name;
                }else {
                    System.out.println("参数错误");
                    return;
                }
                break;

            case FEMALE:
                if (name.equals("女")){
                    this.name = name;
                }else {
                    System.out.println("参数错误");
                    return;
                }
                break;
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
