package com.crazyjava;

import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.Serializable;

/**
 * @Author: Richered
 * @Date: 2020/7/23 23:39
 * @Description:
 */
public class SerialSelection {
    private Serializable obj;

    public SerialSelection(Serializable obj){
        this.obj = obj;
    }

    public DataFlavor[] getTransferDataFlavors(){
        DataFlavor[] flavors = new DataFlavor[2];
        Class clazz = obj.getClass();
        try {
            flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=" + clazz.getName());
            flavors[1] = DataFlavor.stringFlavor;
            return flavors;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (!isDataFlavorSupported(flavor)){
            throw new UnsupportedFlavorException(flavor);
        }
        if (flavor.equals(DataFlavor.stringFlavor)){
            return obj.toString();
        }
        return obj;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor){
        return flavor.equals(DataFlavor.stringFlavor) || flavor.getPrimaryType().equals("application")
                && flavor.getSubType().equals("x-java-serialized-object")
                && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
    }
}
