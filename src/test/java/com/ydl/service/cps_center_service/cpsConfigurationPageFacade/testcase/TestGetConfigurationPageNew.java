package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api.GetConfigurationPageNew;
import io.qameta.allure.Feature;
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
 * @Date: 2020/3/27 17:23
 * Description:
 */
@Feature("TestGetConfigurationPageNew")
public class TestGetConfigurationPageNew {
    @ParameterizedTest
    @MethodSource("getYamlDate")
    public void getConfigurationPageNew(int distributorId, int channelId, int productType){
        GetConfigurationPageNew getConfigurationPageNew = new GetConfigurationPageNew();
        getConfigurationPageNew.get(distributorId, channelId, productType).then().body("code",  equalTo("200"));
    }

    static Stream<Arguments> getYamlDate(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        //生成一个代表List<HashMap>的类型，用于传递给readValue
        TypeReference<List<HashMap<String, Object>>> typeRef = new TypeReference<List<HashMap<String, Object>>>() {};

        List<HashMap<String, Object>> data;
        try {
            data = mapper.readValue(
                    TestGetConfigurationPageNew.class.getResourceAsStream("TestGetConfigurationPageNew.yaml"), typeRef);
            ArrayList<Arguments> results = new ArrayList<>();
            data.forEach(map -> {
                results.add(arguments(
                        map.get("distributorId"),
                        map.get("channelId"),
                        map.get("productType")
                ));
            });

            return results.stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of();
    }
}
