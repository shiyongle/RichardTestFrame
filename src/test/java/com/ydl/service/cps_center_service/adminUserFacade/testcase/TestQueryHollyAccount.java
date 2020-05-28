package com.ydl.service.cps_center_service.adminUserFacade.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ydl.service.cps_center_service.adminUserFacade.api.AdminUserFacade;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:12
 * Description:
 */
@Feature("TestQueryHollyAccount")
public class TestQueryHollyAccount {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("查询某用户账号-正向用例")
    @ParameterizedTest
    @MethodSource("getYamlData")
    public void queryHollyAccount(String name){
        AdminUserFacade adminUserFacade = new AdminUserFacade();
        adminUserFacade.queryHollyAccount(name).then().body("code",  equalTo("200"));
    }

    static Stream<Arguments> getYamlData(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        //生成一个代表List<HashMap>的类型，用于传递给readValue
        TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};

        List<HashMap<String, Object>> data;
        try {
            data = mapper.readValue(
                    TestQueryHollyAccount.class.getResourceAsStream("TestQueryHollyAccount.yaml"), typeRef);
            ArrayList<Arguments> results = new ArrayList<>();
            data.forEach(map -> {
                results.add(arguments(
                        map.get("name").toString()
                ));
            });

            return results.stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of();
    }
}
