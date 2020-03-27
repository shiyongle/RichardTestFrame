package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.testcase;

import com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api.GetConfigurationPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:20
 * Description:
 */
public class TestGetConfigurationPage {
    @Test
    public void getConfig(){
        GetConfigurationPage getConfigurationPage = new GetConfigurationPage();
        getConfigurationPage.get(112, 107, 4).then().body("code",  equalTo("200"));
    }
}
