package com.ydl.appium.testcase;

import com.ydl.appium.page.App;
import com.ydl.appium.page.CoursePage;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 16:47
 * Description:课程用例
 */
public class TestCourse {
    public static CoursePage coursePage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException{
        App.start();
        coursePage = App.toCoursePage();
    }
}
