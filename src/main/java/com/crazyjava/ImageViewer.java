package com.crazyjava;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.awt.image.ImageConsumer;
import java.io.File;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/07/27 19:37
 * @Description:
 **/
public class ImageViewer {
    final int PREVIEW_SIZE = 100;

    JFrame jf = new JFrame("简单图片查看器");

    JMenuBar menuBar = new JMenuBar();

    JLabel label = new JLabel();

    JFileChooser chooser = new JFileChooser(".");

    JLabel accessory = new JLabel();

    ExtensionFileFilter filter = new ExtensionFileFilter();

    class ExtensionFileFilter extends FileFilter{

        private String description;

        private ArrayList<String> exitensions = new ArrayList<>();

        public void addExtension(String exitension){
            if (!exitension.startsWith(".")){
                exitension = "." + exitension;
                exitensions.add(exitension.toLowerCase());
            }
        }

        public void setDescription(String aDescription){
            description = aDescription;
        }

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()){
                return true;
            }
            String name = f.getName().toLowerCase();
            for (String extension: exitensions){
                if (name.endsWith(extension)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    class FileIconView extends FileView{
        private FileFilter filter;

        public FileIconView(FileFilter filter){
            this.filter = filter;
        }

        public Icon getIcon(File f){
            if (!f.isDirectory() && filter.accept(f)){
                return new ImageIcon("ico/pict.png");
            }else if (f.isDirectory()){
                File[] fList = File.listRoots();
                for (File tmp : fList){
                    if (tmp.equals(f)){
                        return new ImageIcon("ico/dsk.png");
                    }
                }
                return new ImageIcon("ico/folder.png");
            }else {
                return null;
            }
        }
    }

    public void init(){
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件（*.jpg, *jpeg, *gif, *png）");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileView(new FileIconView(filter));
        chooser.setAccessory(accessory);

        accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
        accessory.setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(event -> {
            if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
                File f = (File) event.getNewValue();
                if (f == null){
                    accessory.setIcon(null);
                    return;
                }
                ImageIcon icon = new ImageIcon(f.getPath());
                if (icon.getIconWidth() > PREVIEW_SIZE){
                    icon = new ImageIcon(icon.getImage().getScaledInstance(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
                }
                accessory.setIcon(icon);
            }
        });

        JMenu menu = new JMenu("文件");
        menuBar.add(menu);
        JMenuItem openItem = new JMenuItem("打开");
        menu.add(openItem);
        openItem.addActionListener(event ->{
            int result = chooser.showDialog(jf, "打开图片文件");
            if (result == JFileChooser.APPROVE_OPTION){
                String name =  chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
        jf.setJMenuBar(menuBar);
        jf.add(new JScrollPane(label));
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageViewer().init();
    }
}
