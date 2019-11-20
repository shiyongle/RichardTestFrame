package com.ydl.testcase;

import com.ydl.page.App;
import com.ydl.page.MePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;

public class LoginCase {
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
