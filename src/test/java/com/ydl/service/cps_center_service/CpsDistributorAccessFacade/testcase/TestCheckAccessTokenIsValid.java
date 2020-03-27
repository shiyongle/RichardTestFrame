package com.ydl.service.cps_center_service.CpsDistributorAccessFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorAccessFacade.api.CheckAccessTokenIsValid;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:48
 * Description:
 */
public class TestCheckAccessTokenIsValid {
    @Test
    public void CheckAccessToken(){
        CheckAccessTokenIsValid checkAccessTokenIsValid = new CheckAccessTokenIsValid();
        checkAccessTokenIsValid.get(112).then().body("code",  equalTo("200"));
    }
}
