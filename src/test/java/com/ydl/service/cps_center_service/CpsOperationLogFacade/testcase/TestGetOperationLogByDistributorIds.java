package com.ydl.service.cps_center_service.CpsOperationLogFacade.testcase;

import com.ydl.service.cps_center_service.CpsOperationLogFacade.api.GetOperationLogByDistributorId;
import com.ydl.service.cps_center_service.CpsOperationLogFacade.api.GetOperationLogByDistributorIds;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:49
 * Description:
 */
public class TestGetOperationLogByDistributorIds {
    @Test
    public void testGetOperationLogByDistributorId(){
        GetOperationLogByDistributorIds getOperationLogByDistributorIds = new GetOperationLogByDistributorIds();
        getOperationLogByDistributorIds.get(112).then().body("code",  equalTo("200"));
    }
}
