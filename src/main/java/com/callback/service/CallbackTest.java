package com.callback.service;

import com.callback.service.impl.Ricky;
import com.callback.service.impl.Teacher;

/**
 * @Author: Richered
 * @Date: 2020/1/9 14:43
 * Description: 测试类
 * 第一：将老师抽象
 *      将老师抽象之后，对于学生来说，就不需要关心哪位老师来问我问题，只需要根据询问的问题，得出答案，然后告诉提问的老师就可以了，即使老师换了，对于学生来讲没有任何影响
 * 第二：将学生抽象
 *      将学生抽象之后，对于老师来说非常灵活，因为老师未必对一个学生提问，可能同时对三个学生提问，也就可以将成员变量Student变成list<Student>，这样在提问的时候遍历student列表，然后得到每个学生的回答
 * 回调的核心就是回调方将本身即this传递给调用方，这样调用方就可以在调用完毕之后告诉回调方它想要知道的信息
 */
public class CallbackTest {

    public static void main(String []args){
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
    }
}
