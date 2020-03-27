package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.GetAdminUserByName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:46
 * Description:
 */
public class TestGetAdminUserByName {
    @Test
    public void getByName(){
        GetAdminUserByName getAdminUserByName = new GetAdminUserByName();
        getAdminUserByName.getByName("admin").then()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
