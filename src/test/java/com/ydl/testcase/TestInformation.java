package com.ydl.testcase;

import com.ydl.page.App;
import com.ydl.page.InformationPage;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 17:34
 * Description:
 */
public class TestInformation {
    public static InformationPage informationPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        informationPage = App.toInformationPage();
    }
}
