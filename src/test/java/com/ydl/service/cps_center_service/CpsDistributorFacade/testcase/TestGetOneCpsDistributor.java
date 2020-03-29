package com.ydl.service.cps_center_service.CpsDistributorFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorFacade.api.GetOneCpsDistributor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/28 15:15
 * @Description:
 */
public class TestGetOneCpsDistributor {
    @Test
    public void getOneCpsDistributor(){
        GetOneCpsDistributor getOneCpsDistributor = new GetOneCpsDistributor();
        getOneCpsDistributor.get(112).then().body("code",  equalTo("200"));
    }
}
