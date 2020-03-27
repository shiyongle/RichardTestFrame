package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.GetAdminUserByRecentToWork;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:51
 * Description:
 */
public class TestGetAdminUserByRecentToWork {
    @Test
    public void getAdminByRecent(){
        GetAdminUserByRecentToWork getAdminUserByRecentToWork = new GetAdminUserByRecentToWork();
        getAdminUserByRecentToWork.getByRecentName().then().body("code", equalTo("200"))
                .extract().response();
    }
}
