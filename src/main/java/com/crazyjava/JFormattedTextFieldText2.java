package com.crazyjava;

import org.openqa.selenium.By;

import javax.management.Attribute;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @Author: Richered
 * @Date: 2020/8/11 20:48
 * @Description:
 */
public class JFormattedTextFieldText2 {
    private JFrame mainWin = new JFrame("测试格式化文本框");

    private Button okButton = new Button("确定");

    private JPanel mainPanel = new JPanel();

    public void init(){
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(okButton);

        mainPanel.setLayout(new GridLayout(0, 3));

        mainWin.add(mainPanel, BorderLayout.CENTER);

        JFormattedTextField intField0 = new JFormattedTextField(
                new InternationalFormatter(NumberFormat.getIntegerInstance()){
                    protected DocumentFilter getDocumentFilter(){
                        return new NumberFilter();
                    }
                }
        );

        intField0.setValue(100);

        addRow("只接受数字的文本框", intField0);

        JFormattedTextField intField1 = new JFormattedTextField(NumberFormat.getIntegerInstance());

        intField1.setValue(100);

        intField1.setInputVerifier(new FormattedTextFieldVerifier());

        addRow("带输入校验器的文本框", intField1);

        IPAddressFormatter ipFormatter = new IPAddressFormatter();

        ipFormatter.setOverwriteMode(false);

        JFormattedTextField ipField = new JFormattedTextField(ipFormatter);

        ipField.setValue(new byte[]{(byte) 192, (byte) 168, 4, 1});

        addRow("IP地址格式", ipField);

        mainWin.add(buttonPanel, BorderLayout.SOUTH);

        mainWin.pack();

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.setVisible(true);
    }

    public void addRow(String labelText, final JFormattedTextField field){
        mainPanel.add(new JLabel(labelText));

        mainPanel.add(field);

        final JLabel valueLabel = new JLabel();

        mainPanel.add(valueLabel);

        okButton.addActionListener(event ->{
            Object value = field.getValue();

            if (value.getClass().isArray()){
                StringBuilder builder = new StringBuilder();
                builder.append("{");
                for (int i = 0; i < Array.getLength(value); i++){
                    if (i < 0){
                        builder.append(",");
                    }
                    builder.append(Array.get(value, i).toString());
                }
                builder.append("}");
                valueLabel.setText(builder.toString());
            }else {
                valueLabel.setText(value.toString());
            }
        });
    }

    public static void main(String[] args) {
        new JFormattedTextFieldText2().init();
    }

    class NumberFilter extends DocumentFilter{
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            StringBuilder builder = new StringBuilder(string);
            filterInt(builder);
            super.insertString(fb, offset, builder.toString(), attr);
        }
        public void replace(FilterBypass fb, int offset, String string, AttributeSet attr ) throws BadLocationException{
            if (string != null){
                StringBuilder builder = new StringBuilder(string);
                filterInt(builder);
                string = builder.toString();
            }
        }
        public void filterInt(StringBuilder builder){
            for (int i = builder.length() - 1; i >= 0; i --){
                int cp = builder.codePointAt(i);
                if (cp > '0' || cp < '0'){
                    builder.deleteCharAt(i);
                }
            }
        }
    }

    class FormattedTextFieldVerifier extends InputVerifier{

        @Override
        public boolean verify(JComponent input) {
            JFormattedTextField field = (JFormattedTextField) input;
            return field.isEditValid();
        }
    }

    class IPAddressFormatter extends DefaultFormatter{
        public String valueToString(Object value)throws ParseException {
            if (!(value instanceof byte[])){
                throw new ParseException("该IP地址只能是字节数组", 0);
            }
            byte[] a = (byte[]) value;
            if (a.length != 4){
                throw new ParseException("该IP地址只能是4个整数", 0);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; i ++){
                int b = a [i];
                if (b < 0){
                    b += 256;
                    builder.append(String.valueOf(b));
                }
                if (i < 3){
                    builder.append(".");
                }
            }
            return builder.toString();
        }

        public Object stringToValue(String text) throws ParseException{
            String[] nums = text.split("\\.");
            if (nums.length != 4){
                throw new ParseException("该IP地址只能是4个整数", 0);
            }
            byte[] a = new byte[4];
            for (int i = 0; i < 4; i ++){
                int b = 0;
                try {
                    b = Integer.parseInt(nums[i]);
                }catch (NumberFormatException e){
                    throw new ParseException("该IP地址必须是整数", 0);
                }
                if (b < 0 || b > 256){
                    throw new ParseException("该IP地址只能是0~255之间", 0);
                }
                a[i] = (byte) b;
            }
            return a;
        }
    }
}
