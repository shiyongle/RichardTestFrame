package com.ydl.service.cps_center_service.CpsDistributorLandFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorLandFacade.api.GetDistributorTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:36
 * Description:
 */
public class TestGetDistributorTest {
    @Test
    public void getByChannel(){
        GetDistributorTest getDistributorTest = new GetDistributorTest();
        getDistributorTest.get(112, 1, 107).then().body("code",  equalTo("200"));
    }
}
