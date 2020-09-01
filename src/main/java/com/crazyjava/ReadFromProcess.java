package com.crazyjava;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * @Author: Richered
 * @Date: 2020/08/24 12:56
 * @Description:
 **/
public class ReadFromProcess {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
            String buff = null;
            while ((buff = br.readLine()) != null){
                System.out.println(buff);
            }
        }
    }
}
