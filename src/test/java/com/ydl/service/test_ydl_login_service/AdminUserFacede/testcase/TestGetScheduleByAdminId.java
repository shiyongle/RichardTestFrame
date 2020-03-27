package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.GetScheduleByAdminId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:01
 * Description:
 */
public class TestGetScheduleByAdminId {
    @Test
    public void getByAdminId(){

        GetScheduleByAdminId getScheduleByAdminId = new GetScheduleByAdminId();
        getScheduleByAdminId.get(1).then().body("code", equalTo("200"))
                .extract().response();
    }

}
