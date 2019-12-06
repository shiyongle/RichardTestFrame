package com.ydl.appium.testcase;

import com.ydl.appium.page.App;
import com.ydl.appium.page.ConsultationPage;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 16:18
 * Description:咨询用例
 */
public class TestConsultation {
    public static ConsultationPage consultationPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        consultationPage = App.toConsultationPage();
    }
}
