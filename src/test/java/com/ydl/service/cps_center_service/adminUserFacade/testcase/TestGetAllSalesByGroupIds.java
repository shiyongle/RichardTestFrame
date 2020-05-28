package com.ydl.service.cps_center_service.adminUserFacade.testcase;

import com.ydl.service.cps_center_service.adminUserFacade.api.AdminUserFacade;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:47
 * Description: 传数组
 */
@Feature("TestGetAllSalesByGroupIds")
public class TestGetAllSalesByGroupIds {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("查找某组admin-正向用例")
    public void getAllByGroupIds(){
        AdminUserFacade adminUserFacade = new AdminUserFacade();
//        getAllSalesByGroupIds.get([2,1]).then().body("code",  equalTo("200"));
    }
}
