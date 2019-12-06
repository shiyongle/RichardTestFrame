package com.ydl.appium.testcase;

import com.ydl.appium.page.App;
import com.ydl.appium.page.QuestionPage;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 17:32
 * Description:问答用例
 */
public class TestQuestion {
    public static QuestionPage questionPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        questionPage = App.toQuestionPage();
    }
}
