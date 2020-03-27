package com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.testcase;

import com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.api.GetByChannelIdAndTestItemId;
import com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api.GetConfigurationPageNew;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:34
 * Description:
 */
public class TestGetByChannelIdAndTestItemId {
    @Test
    public void getByChannel(){
        GetByChannelIdAndTestItemId getByChannelIdAndTestItemId = new GetByChannelIdAndTestItemId();
        getByChannelIdAndTestItemId.get(107, 100).then().body("code",  equalTo("200"));
    }
}
