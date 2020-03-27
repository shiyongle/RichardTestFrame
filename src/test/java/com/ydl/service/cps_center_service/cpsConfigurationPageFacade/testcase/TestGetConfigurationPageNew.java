package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.testcase;

import com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api.GetConfigurationPageNew;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:23
 * Description:
 */
public class TestGetConfigurationPageNew {
    @Test
    public void getConfigNew(){
        GetConfigurationPageNew getConfigurationPageNew = new GetConfigurationPageNew();
        getConfigurationPageNew.get(112, 107, 4).then().body("code",  equalTo("200"));
    }
}
