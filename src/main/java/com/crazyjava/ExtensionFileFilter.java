package com.crazyjava;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/08/17 19:49
 * @Description:
 **/
public class ExtensionFileFilter extends FileFilter {

    private String description = "";

    private ArrayList<String> extensions = new ArrayList<>();

    public void addExtension(String extension){
        if (!extension.startsWith(".")){
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    public void setDescription(String aDescription){
        description = aDescription;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()){
            return true;
        }
        String name = f.getName().toLowerCase();

        for (String extension :extensions){
            if (name.endsWith(extension)){
                return true;
            }
        }
        return false;
    }
}
