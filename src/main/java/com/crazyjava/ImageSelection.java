package com.crazyjava;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TransferQueue;

/**
 * @Author: Richered
 * @Date: 2020/07/23 13:24
 * @Description:
 **/
public class ImageSelection implements Transferable {

    private Image image;

    public ImageSelection(Image image){
        this.image = image;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.imageFlavor)){
            return image;
        }else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
