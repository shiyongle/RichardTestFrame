package com.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * @Author: Richered
 * @Date: 2020/6/4 10:07
 * Description:
 */
public class SelenideTest {
    @Test
    public void TestBaidu() throws InterruptedException {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://www.baidu.com";
        open("/");
        $("#kw").setValue("selenide");
        $("#su").click();
        Thread.sleep(3000);

        //断言
        $$("h3 > a").shouldHave(size(9));
        $("h3 >a").setValue(String.valueOf(text("selenide_百度翻译")));
    }
}
