package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.SearchAllByName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:18
 * Description:
 */
public class TestSearchAllByName {
    @Test
    public void searchAll(){
        SearchAllByName searchAllByName = new SearchAllByName();
        searchAllByName.searchName("admin").then().body("code",  equalTo("200"));
    }
}
