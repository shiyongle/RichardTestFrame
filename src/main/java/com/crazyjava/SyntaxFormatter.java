package com.crazyjava;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/8/11 21:41
 * @Description:
 */
public class SyntaxFormatter {
    private Map<SimpleAttributeSet, ArrayList<String>> attMap = new HashMap<>();

    SimpleAttributeSet normalAttr = new SimpleAttributeSet();

    public SyntaxFormatter(String syntaxFile){
        StyleConstants.setForeground(normalAttr, Color.BLACK);

        StyleConstants.setFontSize(normalAttr, 16);

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(syntaxFile));
        }catch (FileNotFoundException e){
            throw new RuntimeException("丢失语法文件:" + e.getMessage());
        }

        int color = -1;

        ArrayList<String> keywords = new ArrayList<>();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.startsWith("#")){
                if (keywords.size() > 0 && color > -1){
                    SimpleAttributeSet att = new SimpleAttributeSet();
                    StyleConstants.setForeground(att, new Color(color));
                    StyleConstants.setFontSize(att, 16);
                    attMap.put(att, keywords);
                }
                keywords = new ArrayList<>();
                color = Integer.parseInt(line.substring(1), 16);
            }else {
                if(line.trim().length() > 0){
                    keywords.add(line.trim());
                }
            }
        }
        if (keywords.size() > 0 && color >= -1){
            SimpleAttributeSet att = new SimpleAttributeSet();
            StyleConstants.setForeground(att, new Color(color));
            StyleConstants.setFontSize(att, 16);
            attMap.put(att, keywords);
        }
    }

    public SimpleAttributeSet getNormalAttributeSet(){
        return normalAttr;
    }

    public void setHighLight(StyledDocument doc, String token, int start, int length){
        SimpleAttributeSet currentAttributeSet = null;
        for (SimpleAttributeSet att : attMap.keySet()){
            ArrayList<String> keywords = attMap.get(att);
            for (String keyword : keywords){
                if (keyword.equals(token)){
                    currentAttributeSet = att;
                    break;
                }
            }
        }
        if (currentAttributeSet != null){
            doc.setCharacterAttributes(start, length, currentAttributeSet, false);
        }else {
            doc.setCharacterAttributes(start, length, normalAttr, false);
        }
    }
}
