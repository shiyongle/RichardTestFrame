package com.ydl.service.cps_center_service.CpsOrderSnapFacade.testcase;

import com.ydl.service.cps_center_service.CpsOrderSnapFacade.api.RepairCpsId;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;


/**
 * @Author: Richered
 * @Date: 2020/3/30 14:22
 * Description:
 */
public class TestRepairCpsId {
    @Test
    public void testRepairCpsId(){
        RepairCpsId repairCpsId = new RepairCpsId();
        repairCpsId.get().then().body("code",  equalTo("200"));
    }
}
