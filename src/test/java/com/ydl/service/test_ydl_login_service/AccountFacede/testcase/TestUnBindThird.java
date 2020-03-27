package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.UnBindThird;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * @Author: Richered
 * @Date: 2020/3/27 14:16
 * Description:
 */
public class TestUnBindThird {
    @Test
    public void unBindThird(){
        UnBindThird unBindThird = new UnBindThird();
        unBindThird.GetUnBindThird(13091057).then().body("code", Matchers.equalTo("200"));
    }
}
