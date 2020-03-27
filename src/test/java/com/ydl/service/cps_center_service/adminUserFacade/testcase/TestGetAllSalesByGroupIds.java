package com.ydl.service.cps_center_service.adminUserFacade.testcase;

import com.ydl.service.cps_center_service.adminUserFacade.api.GetAllSalesByGroupIds;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:47
 * Description: 传数组
 */
public class TestGetAllSalesByGroupIds {
    @Test
    public void getAllByGroupIds(){
        GetAllSalesByGroupIds getAllSalesByGroupIds = new GetAllSalesByGroupIds();
//        getAllSalesByGroupIds.get([2,1]).then().body("code",  equalTo("200"));
    }
}
