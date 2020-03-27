package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.GetAssistantUid;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:57
 * Description:
 */
public class TestGetAssistantUid {
    @Test
    public void getAssistantUid(){
        GetAssistantUid getAssistantUid = new GetAssistantUid();
        getAssistantUid.get(true, (byte) 1, true).then().body("code", equalTo("200"))
                .extract().response();
    }
}
