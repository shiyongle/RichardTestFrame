package com.ydl.page;

import org.openqa.selenium.By;

import java.util.HashMap;

public class MePage extends BasePage{

    public MePage login(String username, String password){
        handAlert();
        click(By.id("com.cxzapp.yidianling:id/tv_duration"));
        App.findEelement(By.id("com.cxzapp.yidianling:id/et_phone_number")).sendKeys(username);

//        HashMap<String, Object> data = new HashMap<>();
//        data.put("username",username);
//        data.put("password",password);
//        setParams(data);

        click(By.id("com.cxzapp.yidianling:id/iv_next"));
        App.findEelement(By.id("com.cxzapp.yidianling:id/et_input_password")).sendKeys(password);
        click(By.id("com.cxzapp.yidianling:id/input_iv_next"));

//        parseSteps("login");
        return this;
    }
}
