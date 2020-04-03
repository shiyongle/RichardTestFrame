package com.ydl.service.cps_center_service.CpsOrderSnapFacade.testcase;

import com.ydl.service.cps_center_service.CpsOrderSnapFacade.api.CountByDistributor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 11:13
 * Description:
 */
public class TestCountByDistributor {
    @Test
    public void testCountByDistributor(){
        CountByDistributor countByDistributor = new CountByDistributor();
        countByDistributor.get(112).then().body("code",  equalTo("200"));
    }
}
