package com.ydl.testcase;

import com.ydl.page.App;
import com.ydl.page.ListenPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

/**
 * @Author: Richered
 * @Date: 2019/11/26 16:39
 * Description:倾诉用例
 */
public class TestListen {
    public static ListenPage listenPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        listenPage = App.toListenPage();
    }
}
