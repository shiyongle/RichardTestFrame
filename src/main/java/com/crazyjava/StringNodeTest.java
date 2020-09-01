package com.crazyjava;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author: Richered
 * @Date: 2020/08/24 12:32
 * @Description:
 **/
public class StringNodeTest {

    public static void main(String[] args) {

        String src = "从明天起，做一个幸福的人\n" +
                "喂马，劈柴，周游世界\n" +
                "从明天起，关心粮食和蔬菜\n" +
                "我有一所新房子，面朝大海，春暖花开\n" +
                "从明天起，和每个亲人通信\n" +
                "告诉他们我的幸福\n";

        char[] buffer = new char[32];

        int hasRead = 0;

        try(StringReader sr = new StringReader(src)){
            while ((hasRead = sr.read(buffer)) > 0){
                System.out.println(new String(buffer, 0, hasRead));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

            StringWriter sw = new StringWriter(20);
            sw.write("有一个美丽的新世界,\n");
            sw.write("她在远方的等我,\n");
            sw.write("那里有天真的孩子,\n");
            sw.write("还有姑娘的酒窝,\n");
            System.out.println("---下面是sw字符串节点里的内容---");
            sw.toString();

    }
}
