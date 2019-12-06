package com.ydl.appium.testcase;

import com.ydl.appium.page.App;
import com.ydl.appium.page.MePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
/**
 * @Author: Richered
 * @Date: 2019/11/26 16:04
 * Description: 登录用例
 */
public class TestLogin {
    public static MePage mePage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException{
        App.start();
        mePage = App.toMePage();
    }
    @Test
    public void login() throws MalformedURLException {
        App.toMePage().login("13216101995","s19951226");
    }
}
