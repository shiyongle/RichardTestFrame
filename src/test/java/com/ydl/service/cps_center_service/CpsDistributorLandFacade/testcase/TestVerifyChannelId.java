package com.ydl.service.cps_center_service.CpsDistributorLandFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorLandFacade.api.VerifyChannelId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:43
 * Description:
 */
public class TestVerifyChannelId {
    @Test
    public void testVerifyChannelId(){
        VerifyChannelId verifyChannelId = new VerifyChannelId();
        verifyChannelId.get(112, 107).then().body("code",  equalTo("200"));
    }
}
