package com.crazyjava;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

/**
 * @Author: Richered
 * @Date: 2020/08/09 21:22
 * @Description:
 **/
public class ImageCellEditor extends DefaultCellEditor {

    private JFileChooser fDialog = new JFileChooser();

    private JTextField field = new JTextField(15);

    private JButton button = new JButton("...");

    public ImageCellEditor() {
        super(new JTextField());
        initEdit();
    }

    public void initEdit(){
        field.setEditable(false);

        button.addActionListener(e -> browse());

        fDialog.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                }
                String extension = Utils.getExension(f);
                if (extension != null){
                    if (extension.equals(Utils.tiff) || extension.equals(Utils.tif) || extension.equals(Utils.gif)
                      || extension.equals(Utils.jpeg) || extension.equals(Utils.jpg) || extension.equals(Utils.png)){
                        return true;
                    }else {
                        return false;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "有效的图片文件";
            }
        });
        fDialog.setAcceptAllFileFilterUsed(false);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        this.button.setPreferredSize(new Dimension(20, 20));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        field.setText(value.toString());
        panel.add(this.field, BorderLayout.CENTER);
        panel.add(this.button, BorderLayout.EAST);
        return panel;
    }

    public Object getCellEditorValue(){
        return new ImageIcon(field.getText());
    }

    private void browse(){
        fDialog.setCurrentDirectory(new File("icon"));
        int result = fDialog.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION){
            super.cancelCellEditing();
            return;
        }else {
            field.setText("icon/" +fDialog.getSelectedFile().getName());
        }
    }


    static class Utils{
        public final static String jpeg = "jpeg";
        public final static String jpg = "jpg";
        public final static String gif = "gif";
        public final static String tiff = "tiff";
        public final static String tif = "tif";
        public final static String png = "png";

        public static String getExension(File f){
            String ext = null;

            String s = f.getName();

            int i = s.lastIndexOf(", ");

            if (i > 0 && i < s.length() - 1){
                ext = s.substring(i + 1).toLowerCase();
            }
            return ext;
        }
    }



}
