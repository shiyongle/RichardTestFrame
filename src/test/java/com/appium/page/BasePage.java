package com.appium.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Richered
 * @Date:2019/11/20 23:54
 * @Description:基类封装，异常、弹窗处理、测试步骤解析
 */
public class BasePage {
    public static AndroidDriver<WebElement> driver;

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    private PageObjectModel model=new PageObjectModel();

    private static HashMap<String,Object> params;

    private static HashMap<String,Object> results = new HashMap<>();

    //TODO:测试步骤参数化
    public void setParams(HashMap<String,Object> params){
        this.params = params;
    }

    public static HashMap<String, Object> getParams() {
        return params;
    }

    //TODO:测试结果读取
    public static HashMap<String, Object> getResults(){
        return results;
    }

    //TODO:通用元素定位与异常处理机制
    public static WebElement findElement(By by) {
        //TODO: 递归是更好的
        //TODO: 如果定位的元素是动态变化位置
        logger.info("findElement by: " + by);
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
            return driver.findElement(by);
        }
    }

    public static void click(By by) {
        //TODO: 递归是更好的
        logger.info("click by : " + by);
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();
            driver.findElement(by).click();
        }
    }

    public static List<WebElement> findElements(By by) {
        logger.info("findElements by :" + by);
        return driver.findElements(by);
    }

    static void handleAlert() {
        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        List<By> alertBoxs = new ArrayList<>();
        //TODO: 不需要所有的都判断是否存在
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        alertBoxs.add(tips);
        alertBoxs.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));
//        alertBoxs.add(By.xpath("dddd"));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            List<WebElement> ads = driver.findElements(alert);

            if (alert.equals(tips)) {
                logger.info("----snb_tip found----");
                Dimension size = driver.manage().window().getSize();
                try {
                    if (driver.findElements(tips).size() >= 1) {
                        new TouchAction(driver).tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    logger.info("----snb_tip clicked----");
                }
            } else if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static void handleAlertByPageSource() {
        //TODO: xpath匹配， 标记 定位
        String xml = driver.getPageSource();
        List<String> alertBoxs = new ArrayList<>();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });

    }

    public void parseSteps(){
        String method=Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("method : " + method);
        parseSteps(method);
    }
    public void parseSteps(String method) {
//        HashMap<String, List<HashMap<String, String>>> 可以取消steps的多余关键字
        //TODO: 参数化，把关键数据参数化到你的yaml中
        String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
        parseSteps(path, method);
    }
    public void parseSteps(String path, String method){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TypeReference<HashMap<String, PageObjectMethod>> typeRef = new TypeReference<HashMap<String, PageObjectMethod>>() {
//        };
        try {
            model = mapper.readValue(
                    BasePage.class.getResourceAsStream(path), PageObjectModel.class
            );
            parseSteps(model.methods.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void parseSteps(PageObjectMethod steps){
        steps.getSteps().forEach(step->{
            WebElement element = null;

            //TODO: 多个可能定位，多平台支持，多版本的支持
            String id=step.get("id");
            if(id!=null){
                element=driver.findElement(By.id(id));
            }else if(step.get("xpath")!=null){
                element=driver.findElement(By.xpath(step.get("xpath")));
            }else if(step.get("aid")!=null){
                element=driver.findElement(MobileBy.AccessibilityId(step.get("aid")));
            }else if(step.get("element")!=null){
                element=driver.findElement(model.elements.get(step.get("element")).getLocator());
            }

            String send=step.get("send");
//            params.entrySet().forEach(kv->{
//                send=send.replace("{"+ kv.getKey() +"}", kv.getValue().toString());
//            });



            if(send!=null){
                //配置文件中的参数替换
                for(Map.Entry<String, Object> kv: params.entrySet()){
                    String matcher="${"+kv.getKey()+"}";
                    if(send.contains(matcher)) {
                        logger.info("kv : " + kv);
                        send = send.replace(matcher, kv.getValue().toString());
                    }
                }
                element.sendKeys(send);
            }else if(step.get("get")!=null){
                String attribute=element.getAttribute(step.get("get"));
                getResults().put(step.get("dump"), attribute);
            }else{
                element.click();
            }
        });
    }
}
