package com.testng.dataclass;


import io.qameta.allure.*;
import org.testng.annotations.Test;
//import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static java.lang.String.format;
import static java.nio.file.Files.readAllBytes;
import static org.testng.Assert.fail;

/**
 * @Author: Richered
 * @Date: 2019/12/18 14:02
 * Description:实例化数据源，及allure注解
 * @Epic：敏捷的术语，定义为史诗，往下再分Feature和Story（没啥用）
 * @Feature：敏捷的术语，定义为功能模块（可区分模块用例）
 * @Story：敏捷的术语，定义为用户故事（可说明该用例测试功能的描述）
 * @Title:定义用例名称
 * @Description:定义用例描述
 * @Issue:定义缺陷链接，可结合@Link使用，也可以结合配置文件使用。配置文件放到resource目录下，Allure 会替换{}为对应注解的值。
 * @TmsLink:与Issure类似，定义案例链接
 * @Link:定义一个链接，在测试报告展示
 * @Severity:定义用例级别，默认NORMAL（主要有BLOCKER,CRITICAL,MINOR,NORMAL,TRIVIAL）.
 * @Attachment：添加已有附件或者新建附件后添加至测试报告
 */
public class TestNgDataClass {
    @Epic("Allure Epic")
    @Feature("Allure Feature")
    @Story("failedTest")
//    @Title("small demo")
    @Description("cs")
    @Issue("test")
    @TmsLink("test-tmslink")
    @Link("")
    @Severity(SeverityLevel.TRIVIAL)
    @Attachment(value = "附件",type = "properties")
    @Test(dataProvider = "DataProviderTest",dataProviderClass = DataProviderTest.class)
    public byte[] test(String name1, String name2, String name3)throws IOException, URISyntaxException {
        System.out.println(name1 + "," + name2 + "," + name3);
        return getSampleFile("allure.properties");
    }


    /**
     * 此处追加allure.properties配置文件中的链接
     * @param fileName
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    private byte[] getSampleFile(String fileName) throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if(resource == null){
            fail(format("Couldn't find resource '%s'", fileName));
        }

        return readAllBytes(Paths.get(resource.toURI()));
    }

    /**
     * 自定义报告追加内容
     * @return
     */
    @Attachment
    public String makeAttach() {
        return "Richard";
    }
}
