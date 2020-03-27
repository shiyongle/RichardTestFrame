package com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.testcase;

import com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.api.RestoreDefault;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:40
 * Description:
 */
public class TestRestoreDefault {
    @Test
    public void restore(){
        RestoreDefault restoreDefault = new RestoreDefault();
        restoreDefault.get(107, 100).then().body("code",  equalTo("200"));
    }
}
