package com.ydl.service.cps_center_service.CpsDistributorLandFacade.testcase;

import com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.api.GetByChannelIdAndTestItemId;
import com.ydl.service.cps_center_service.CpsDistributorLandFacade.api.GetDistributorLand;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:31
 * Description:
 */
public class TestGetDistributorLand {
    @Test
    public void getByChannel(){
        GetDistributorLand getDistributorLand = new GetDistributorLand();
        getDistributorLand.get(112, 1, 107, 1, 1).then().body("code",  equalTo("200"));
    }
}
