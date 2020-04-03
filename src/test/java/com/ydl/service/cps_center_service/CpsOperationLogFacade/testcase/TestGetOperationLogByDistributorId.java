package com.ydl.service.cps_center_service.CpsOperationLogFacade.testcase;

import com.ydl.service.cps_center_service.CpsOperationLogFacade.api.GetOperationLogByDistributorId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:46
 * Description:
 */
public class TestGetOperationLogByDistributorId {
    @Test
    public void testGetOperationLogByDistributorId(){
        GetOperationLogByDistributorId getOperationLogByDistributorId = new GetOperationLogByDistributorId();
        getOperationLogByDistributorId.get(112).then().body("code",  equalTo("200"));
    }
}
