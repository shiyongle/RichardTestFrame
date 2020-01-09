package com.callback.service.impl;

import com.callback.service.Callback;
import com.callback.service.Student;
import mock.TestLog;

/**
 * @Author: Richered
 * @Date: 2020/1/9 14:26
 * Description: 老师对象，实现回调接口
 * 将老师抽象：
 *       将老师抽象之后，对于学生来说，就不需要关心哪位老师来问我问题，只需要根据询问的问题，得出答案，然后告诉提问的老师就可以了，即使老师换了，对于学生来讲没有任何影响
 * 将学生抽象：
 *       将学生抽象之后，对于老师来说非常灵活，因为老师未必对一个学生提问，可能同时对三个学生提问，也就可以将成员变量Student变成list<Student>，这样在提问的时候遍历student列表，然后得到每个学生的回答
 *
 */
public class Teacher implements Callback {

    private Student student;
    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
       System.out.println("知道了，你的答案是" + answer);
    }
}
