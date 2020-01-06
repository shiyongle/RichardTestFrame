package com.unit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Richered
 * @Date: 2020/1/6 21:50
 * Description:
 */
public class TestJson {

    @Test
    public void sequen(){
        JSONObject persons = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        JSONObject  bean1=new JSONObject();
        bean1.put("name", "小明");
        bean1.put("sex", "男");

        JSONObject bean2 = new JSONObject();
        bean2.put("name", "小红");
        bean2.put("sex", "女");

        jsonArray.add(bean1);
        jsonArray.add(bean2);
        persons.put("persons", jsonArray);

        System.out.println(persons.toJSONString());
    }

    @Test
    public void sequenTest(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();

        String user1 = "user1";
        String user2 = "user2";
        jsonArray1.add(user1);
        jsonArray1.add(user2);

        int parylist = 3;
        jsonArray2.add(parylist);

        jsonObject.put("tagid",1);
        jsonObject.put("userlist",jsonArray1);
        jsonObject.put("partylist",jsonArray2);
        System.out.println(jsonObject);
    }
}
