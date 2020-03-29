package com.ydl.service.cps_center_service.CpsDistributorFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorFacade.api.GetAllCpsDistributor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/28 15:11
 * @Description:
 */
public class TestGetAllCpsDistributor {
    @Test
    public void getAllCpsDistributor(){
        GetAllCpsDistributor getAllCpsDistributor = new GetAllCpsDistributor();
        getAllCpsDistributor.get("112", 1,1).then().body("code",  equalTo("200"));
    }
}
