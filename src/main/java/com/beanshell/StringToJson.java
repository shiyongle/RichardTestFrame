package com.beanshell;

import com.alibaba.fastjson.JSONObject;


/**
 * @Author: Richered
 * @Date: 2022/3/15 20:52
 * @Description 数据转换 16进制转化json，字符串转换为十六进制
 */
public class StringToJson {


//    static String data = "000000F9000F000103E800007817007B2261707056657273696F6E223A22222C226175746F4C6F67696E223A747275652C226465766963654964223A22222C226A6964223A2231363738303333302F705F7765625F6D6F6E69746F72222C2273646B56657273696F6E223A22222C22746F6B656E223A2278326E74504E5833327A4150346C534B73567066497041586F5149774943447774345071786B3930536F4F444B4B69516A523641356365584166356859414A4473434D6448654E583258732B372B4B736E4D30396C635677676948794459544C4157377149755672374B436D7A6E4859445A526D2B3670673951573554356672227D";
    static String data = null;

    String json = "{\"jid\":\"5559913/apple\",\"userSourceId\":1,\"deviceId\":\"sadad12412323312132\",\n" +
            "\n" +
            "\"token\":\"ggvTo6lU69Mxtx2L1v2eDJEw1eRfYjkE9WcTHwnFF\",\"autoLogin\":true,\n" +
            "\n" +
            " \"deviceToken\":\"vvsada\",\"appVersion\":\"2.9.4\",\"sdkVersion\":\"1.0.0\"}";



    public static void main(String[] args) throws Exception {
        JSONObject json = new JSONObject();
        json.put("appVersion", "");
        json.put("autoLogin", true);
        json.put("deviceId", "");
        json.put("jid", "16780330/p_web_monitor");
        json.put("sdkVersion", "");
        json.put("token", "xxxxxx");
        String json1 = json.toJSONString();

        System.out.println(toHexString(json1));
    }


    /**
     * 16进制转换为json
     * @param s
     * @return
     */
    public static String toStringHex(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 字符串转换为十六进制
     * @param str
     * @return
     * @throws Exception
     */
    public static String toHexString(String str) throws Exception{
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int ch = (int) str.charAt(i);
            String strHex = Integer.toHexString(ch);
            hexString.append(strHex);
        }
        return hexString.toString();
    }
}
