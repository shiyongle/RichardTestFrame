package com.ydl.appium.testcase;

import com.ydl.appium.page.App;
import com.ydl.appium.page.SearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/12/6 10:08
 * Description:搜索用例
 */
public class TestSearch {
    public static SearchPage searchPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage = App.toSearchPage();
    }

    @Test
    public void search(){
        App.toSearchPage().search("xxx");
    }
}
