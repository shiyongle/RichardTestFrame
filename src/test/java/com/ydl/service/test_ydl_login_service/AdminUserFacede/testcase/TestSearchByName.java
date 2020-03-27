package com.ydl.service.test_ydl_login_service.AdminUserFacede.testcase;

import com.ydl.service.test_ydl_login_service.AdminUserFacede.api.SearchByName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:21
 * Description:
 */
public class TestSearchByName {
    @Test
    public void searchName(){
        SearchByName searchByName = new SearchByName();
        searchByName.search("admin", 1 , 1).then().body("code",  equalTo("200"));
    }
}
