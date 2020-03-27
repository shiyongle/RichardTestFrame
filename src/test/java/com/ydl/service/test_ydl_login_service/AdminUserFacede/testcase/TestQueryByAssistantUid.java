package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.QueryByAssistantUid;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:15
 * Description:
 */
public class TestQueryByAssistantUid {
    @Test
    public void queryByAssistant(){
        QueryByAssistantUid queryByAssistantUid = new QueryByAssistantUid();
        queryByAssistantUid.getByAssistant(1).then().body("code",  equalTo("200"));
    }
}
