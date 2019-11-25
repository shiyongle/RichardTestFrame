package com.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2019/11/21 0:01
 * @Description:
 */
public class TestResources {
    public String name;
    public int age;

    @Test
    public void readFile() throws IOException {
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/com/appium/testcase/TestSearch.yaml"));
        System.out.println(
                FileUtils.readFileToString(
                        new File(
                                this.getClass().getResource("/com/appium/testcase/TestSearch.yaml").getPath()), "UTF-8"));

    }

    @Test
    public void writeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("demo.json"), this);

    }

    @Test
    public void readJson() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        TestResources demo=mapper.readValue(new File("demo.json"), this.getClass());
        System.out.println(demo);
        System.out.println(demo.name);
    }

    @Test
    public void readYaml() throws IOException {
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        Object[][] demo=mapper.readValue(this.getClass().getResourceAsStream("/com/appium/testcase/TestSearch.yaml"),
                Object[][].class);
        System.out.println(demo);

        System.out.println(demo.length);
        System.out.println(demo[0].length);
        System.out.println(demo[0]);
        System.out.println(demo[0][0]);

    }
}
