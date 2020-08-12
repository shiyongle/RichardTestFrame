package com.crazyjava;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/08/09 22:09
 * @Description:
 **/
public class JFormattedTextFieldTest {
    private JFrame mainWin = new JFrame("测试格式化文本框");

    private JButton okButton = new JButton("确定");

    private JPanel mainPanel = new JPanel();

    JFormattedTextField[] fields = new JFormattedTextField[6];

    String[] behaviorLabels = new String[]{
            "COMMIT",
            "COMMIT_OR_REVERT",
            "PERSIST",
            "REVERT"
    };

    int[] behaviors = new int[]{
            JFormattedTextField.COMMIT,
            JFormattedTextField.COMMIT_OR_REVERT,
            JFormattedTextField.PERSIST,
            JFormattedTextField.REVERT
    };

    ButtonGroup bg = new ButtonGroup();

    public void init(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        mainPanel.setLayout(new GridLayout(0, 3));
        mainWin.add(mainPanel, BorderLayout.CENTER);
        fields[0] = new JFormattedTextField(NumberFormat.getIntegerInstance());
        fields[0].setValue(100);
        fields[1] = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        fields[1].setValue(100.0);
        fields[2] = new JFormattedTextField(DateFormat.getDateInstance());
        fields[2].setValue(new Date());
        addRow("默认的日期格式器", fields[2]);
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
        format.setLenient(false);
        fields[3] = new JFormattedTextField(format);
        fields[3].setValue(new Date());
        addRow("SHORT类型的日期格式器（语法严格）：" , fields[3]);
        try {
            DefaultFormatter formatter = new DefaultFormatter();
            formatter.setOverwriteMode(false);
            fields[4] = new JFormattedTextField(formatter);
            fields[4].setValue(new URL("http://crazyit.org"));
            addRow("URL", fields[4]);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        try {
            MaskFormatter formatter = new MaskFormatter("020-###########");
            formatter.setPlaceholderCharacter('a');
            fields[5] = new JFormattedTextField(formatter);
            fields[5].setValue("020-2831212");
            addRow("电话号码", fields[5]);
        }catch (ParseException e){
            e.printStackTrace();
        }

        JPanel focusLostPanel = new JPanel();
        for (int i = 0; i < behaviorLabels.length; i++){
            final int index = i;
            final JRadioButton radio = new JRadioButton(behaviorLabels[i]);
            if (i == 1){
                radio.setSelected(true);
            }
            focusLostPanel.add(radio);
            bg.add(radio);
            radio.addActionListener(e -> {
                if (radio.isSelected()){
                    for (int j = 0; j < fields.length; j++){
                        fields[j].setFocusLostBehavior(behaviors[index]);
                    }
                }
            });
        }

        focusLostPanel.setBorder(new TitledBorder(new EtchedBorder(), "请选择焦点失去后的行为"));
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(focusLostPanel, BorderLayout.NORTH);
        p.add(buttonPanel, BorderLayout.SOUTH);
        mainWin.add(p, BorderLayout.SOUTH);
        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {

        new JFormattedTextFieldTest().init();
    }

    private void addRow(String labelText, final JFormattedTextField field){
        mainPanel.add(new JLabel(labelText));
        mainPanel.add(field);
        final JLabel valueLabel = new JLabel();
        mainPanel.add(valueLabel);
        okButton.addActionListener(event ->{
            Object value = field.getValue();
            valueLabel.setText(value.toString());
        });
    }
}
