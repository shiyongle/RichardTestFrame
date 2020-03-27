package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.GetAdminUser;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:41
 * Description:
 */
public class TestGetAdminUser {
    @Test
    public void get(){
        GetAdminUser getAdminUser = new GetAdminUser();
        getAdminUser.get(1).then().body("code",  equalTo("200"));
    }
}
