package com.weiyi;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.inter.GreetingsService;
import com.guahao.portal.membership.service.common.model.OpUser;
import com.guahao.portal.membership.service.viporder.VipRefundService;
import com.guahao.portal.membership.service.viporder.model.ApplyRefundReq;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.groovy.util.ListHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Richered
 * @Date: 2021/11/3 16:01
 * @Description
 */
public class AresInvalidTest {
    private static String invalidUrl = "http://ares-gops-stable.guahao-test.com/rest/viporder/invalid";

    /**
     * @param map
     * @return
     * @throws Exception
     */
    public String getInvalid(Map<String, String> map) throws Exception {

        String body = "";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(invalidUrl);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null){
            for (Map.Entry<String, String> entry : map.entrySet()){
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        System.out.println("请求url:" + invalidUrl);
        System.out.println("请求参数：" + nvps.toString());
        httpPost.setHeader("Connect-type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("encoding", "UTF-8");
        httpPost.setHeader("cookie", "edbc3520485a197446c84db253903d7d; _gsid_=3mlKYQj4CWjpYuy3WF4STDiBDPkHjkFhyNZIC4Oyy8e9Nt0Gv7i6XZJjx1mCUYJi; _grms_sid_=16367053787655216679821; _wye_m=1636791938889; _wysid_=16367919388801562879568; _source_id_=41236; _portal_hostname_=mpunicom.f.guahao-test.com; __sourceType__=mpunicom; __wy_partner_name__=mpunicom; monitor_sid=1; mst=1636946997741; monitor_seq=1; mlt=1636946997742; _gi___=DXKrNZf6V/bsECP/plLvrMOFfOy0OTWEi7HamxBAeEE=; __u__t__=Q+rMIXBRk7rDx2cWAznn/GeLcoegbYeH56ilXzq67tHh9TczJOen2Q==; _u__a_=5gc8kPEmKcJXk2iUuJpec8Xiv66SQii22QPa62huLrqQbKotfkxWwPSJlNfRSBab/UWHfg1IjobXo26f5gWj7W0TryYW95yC9b2sL5fx6SELVWJHSRXGS75Cuc6yxoqr7mWAp0GF7Qp1ySK/ipeCiUkewz8SXo4kmFy1g2KNvzQNdWA9ARzGK0OXKiTFQyu5I+uofVlQJFx82J6W96TvSDTdGNO2sqp3V9S4Qkqwu1yPyA4fXN8WTZswzEfoy/KTy+77ESJUoDbD1QDroz7IV36Dw7QwBgmwPRDdsAy469pFWhR1XFc00yNnKylhop5oYGE+dWjw/7TSLW0EBDd1+tPfaIEwXOf8AYguAY9K58el9VwXJ5h6G5pYMkCo9NMk1mdZKp6zn9/kiBwi4vBdQNFF+M9PreW+EbLy38BTM578Nf1DjWzju6tzLs0fmUAvBjHNDmdhWDRdTJY89RGtjZsSw7HY/jUZSCdWi+y55ylS+fxxmCuUD0fa4KDswd6/Us1zweW3Q3Ch12DKaUV5LQIpUbcoANooyixpnqcG4jYuv2Y6QUWAfuCFdr+GGFJpTMRLEpt794T/SoqHZVoD7LYJdsOJM/5rgxud26WknKGTnOaHxi19/w==; _gp___=0fYqWKV8zeSZjv0Sxp6OUVx2m6F6JGYdjC8t4UnXQPxyCGOPrMfQUw==; _guli___=12/ZQgDusCvfj1S2ypEijeJkQZBOeZei6EC6eAl6XstnRhTQxcBDyD3LZl0pWKGlI1V49gLYm0c=; ___lt_=nLdVAYf97Nxp50J5+IFlgMRTSjIfLYhilMZ6IsQBj2t77Zwuz1ft6NAICv/6pORJ; ___lk__=ULCWUGUF9Y/rBYmVG92kviPLd1XijM4y3vyCMCGYr6kqkdOUfDo7OQ==");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36");
        httpPost.setHeader("Origin", "http://ares-gops-stable.guahao-test.com");
        httpPost.setHeader("Referer", "http://ares-gops-stable.guahao-test.com/viporder/list");

        CloseableHttpResponse response = client.execute(httpPost);

        HttpEntity entity = response.getEntity();
        if (entity != null){
            body = EntityUtils.toString(entity);
        }
        EntityUtils.consume(entity);
        response.close();
        return body;
    }

    @Test
    public void getInvalidTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("refundRemark", "测试操作");
        map.put("recycleCoupon", "1");
        map.put("hasConfirm", "0");
        map.put("orderNo", "202111171930211809000023675");

        String body = getInvalid(map);
        System.out.println("响应结果：");
        System.out.println(body);
    }

    @Resource
    VipRefundService vipRefundService;

    @BeforeAll
    static void beforeAll(){
        //寻找zk
        String dubboHost = System.getProperty("zookeeper.address", "192.168.99.51");

        //配置
        ReferenceConfig<VipRefundService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("dubbo://" + dubboHost + ":2183"));
        reference.setInterface(VipRefundService.class);
        reference.setGeneric(true);
        Object vipRefundService = reference.get();
    }


    @Test
    public void testRefund(){
        ApplyRefundReq applyRefundReq = new ApplyRefundReq();
        OpUser opUser = new OpUser();

        opUser.setUserId((long) 17442);
        opUser.setUsername("杨秉晨");

        applyRefundReq.setOrderNo("202111171930211809000023675");
        applyRefundReq.setOpUser(opUser);
        applyRefundReq.setRefundAmount((long) 0);
        applyRefundReq.setRefundRemark("测吧操作");
        applyRefundReq.setApplyType(2);
        applyRefundReq.setRecycleCoupon(1);

        vipRefundService.applyRefund(applyRefundReq);
    }
}
