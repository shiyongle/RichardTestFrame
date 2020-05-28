package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.testcase;

import com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api.GetPreviewConfigurationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:25
 * Description:
 */
@Feature("TestGetPreviewConfigurationPage")
public class TestGetPreviewConfigurationPage {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("")
    public void testGet(){
        GetPreviewConfigurationPage getPreviewConfigurationPage = new GetPreviewConfigurationPage();
        HashMap<String , Object> data = new HashMap<>();
        getPreviewConfigurationPage.getPreviewConfigurationPage(data).then().body("code", equalTo(200));
    }
}
