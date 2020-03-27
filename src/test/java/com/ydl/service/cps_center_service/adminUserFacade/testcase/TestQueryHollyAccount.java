package com.ydl.service.cps_center_service.adminUserFacade.testcase;

import com.ydl.service.cps_center_service.adminUserFacade.api.QueryHollyAccount;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:12
 * Description:
 */
public class TestQueryHollyAccount {
    @Test
    public void queryHollyAccount(){
        QueryHollyAccount queryHollyAccount = new QueryHollyAccount();
        queryHollyAccount.get("admin").then().body("code",  equalTo("200"));
    }
}
