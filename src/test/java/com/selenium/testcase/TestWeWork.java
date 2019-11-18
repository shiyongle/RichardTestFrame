package com.selenium.testcase;
/**
 * @Author Richered
 * PO Case
 * 该类只存在测试数据、测试断言、业务行为
 */

import com.selenium.page.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWeWork {
    public static App app;
    @BeforeClass
    public static void beforeAll(){
        app = new App();
        app.loginWithCookie();
        String phone = "17826978285";
        app.toContact().delete(phone);
    }
    @Test
    public void add(){
        String phone = "17826978285";
        app.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void delete(){
        String phone = "17826978285";
        app.toMemberAdd().add(phone,phone,phone).delete(phone);
    }

    @Test
    public void deleteCurrentPage(){
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void importFromFile(){
        app.toContact().importFromFile("/Users/seveniruby/Downloads/通讯录批量导入模板.xlsx");
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
