package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.ListByIds;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:05
 * Description:
 */
public class TestListByIds {
    @Test
    public void list(){
        ListByIds listByIds = new ListByIds();
        listByIds.list().then().body("code", equalTo("200"))
                .extract().response();
    }

}
