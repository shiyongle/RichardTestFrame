package com.crazyjava;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author: Richered
 * @Date: 2020/08/24 12:59
 * @Description:
 **/
public class WriteToProcess {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try(PrintStream ps = new PrintStream(p.getOutputStream())){
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
    }
}
