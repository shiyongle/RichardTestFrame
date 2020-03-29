package com.ydl.service.cps_center_service.CpsDistributorFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorFacade.api.GetOneCpsDistributorByAccount;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/28 15:21
 * @Description:
 */
public class TestGetOneCpsDistributorByAccount {
    @Test
    public void getOneCpsDistributorByAccount(){
        GetOneCpsDistributorByAccount getOneCpsDistributorByAccount = new GetOneCpsDistributorByAccount();
        getOneCpsDistributorByAccount.get("波霸奶茶").then().body("code",  equalTo("200"));
    }
}
