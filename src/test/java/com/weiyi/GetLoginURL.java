package com.weiyi;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weiyi.Utils.AESUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 用户访问接口，
 * @date 2014/10/23
 * @Version V1.0
 *
 * 背景：不同的ext_user_id，相同的手机号码是不需要重新联合登录；
 * 更改点：防盗用，不同的ext_user_id,相同的手机号码需要重新联合登录
 */

public class GetLoginURL {
    // 加密key
    private static String secretkey = "fXU2#RhK43C6MtSRX&c3K2OPdFCa2x6S";
    // 客户端key
    private static String clientKey = "H5rG291iVYPFZ0XUoYTqfEEd64WYxhHRkyyTGFodw90jFbPv91Lar4IsMvdMsrKo";
    // 随机数
    private static String nonce = "cf498ee4-62f1-4327-900f-449d76d91d42";

    private static final String PARTNERS_ADD_DATA_KE = "123!@#add_data)(*789";

    public static void main(String args[]) throws UnsupportedEncodingException, JSONException {
        wy();
    }

    private static void wy() throws JSONException, UnsupportedEncodingException {
        // 单项服务target地址
        // 私人医生
//        String target = "http://aialtmmins.vip-h5-node-q.guahao-test.com/vip/diplomat/auto?target="
        String target = "http://aialtmmins.vip.guahao.com/vip/diplomat/auto?target="
                + URLEncoder.encode("/corp/consult/intro?subjectCode=wy01.01.52.WwRPX1pb&customQuery=1");
        Map<String, String> params = new HashMap<String, String>();
        params.put("ext_user_id", "aialtmmins-20201223-test");
        params.put("mobile", "13216101995");
        params.put("name", "石永乐");
        params.put("idcard", "610527199512261813");
        params.put("idcard_type", "1");
        params.put("tagCode", "PD41090-A");
        params.put("effective_date", "2020-11-10");
        params.put("target", target);
        long timestamp = System.currentTimeMillis();
        String encryptResultStr = AESUtils.ecodes(JSONObject.toJSONString(params), secretkey);
        String data = encryptResultStr + timestamp + nonce + clientKey;
        String sign = Sha256Utils.getSHA256(data);
        String token = URLEncoder.encode(encryptResultStr, "utf-8");
        // 请求地址
//        String url = "http://aialtmmins.s.guahao-test.com/partners/entrance?token=" + token + "&timestamp=" + timestamp
        String url = "http://aialtmmins.wy.guahao.com/partners/entrance?token=" + token + "&timestamp=" + timestamp
                + "&nonce=" + nonce + "&signature=" + sign;
        System.out.println(url);
    }

}
