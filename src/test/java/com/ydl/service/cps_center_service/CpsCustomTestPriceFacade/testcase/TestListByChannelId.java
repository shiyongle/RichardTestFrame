package com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.testcase;

import com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.api.ListByChannelId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:38
 * Description:
 */
public class TestListByChannelId {
    @Test
    public void listByChannel(){
        ListByChannelId listByChannelId = new ListByChannelId();
        listByChannelId.get(107).then().body("code",  equalTo("200"));
    }
}
