package com.ydl.service.cps_center_service.CpsDistributorLandFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorLandFacade.api.GetDistributorTest;
import com.ydl.service.cps_center_service.CpsDistributorLandFacade.api.GetTestName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:40
 * Description:
 */
public class TestGetTestName {
    @Test
    public void getByChannel(){
        GetTestName getTestName = new GetTestName();
        getTestName.get(728).then().body("code",  equalTo("200"));
    }
}
