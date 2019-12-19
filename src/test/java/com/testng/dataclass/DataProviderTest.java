package com.testng.dataclass;

//import org.testng.annotations.DataProvider;

/**
 * @Author: Richered
 * @Date: 2019/12/18 14:07
 * Description:dataProvider方式:返回数据类型必须为Object[][]，或者Iterator<Object[]>
 */
public class DataProviderTest {
//    @DataProvider(name = "DataProviderTest")
    public Object[][] Datatest(){
        return new Object[][]{
                {"username","shiyongle"}
        };
    }
}
