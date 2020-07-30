package com.crazyjava;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/07/28 11:12
 * @Description:
 **/
public class JOptionPaneTest {
    JFrame jf = new JFrame("测试JOptionPane");

    private ButtonPanel messagePanel;

    private ButtonPanel messageTypePanel;

    private ButtonPanel msgPanel;

    private ButtonPanel confirmPanel;

    private ButtonPanel optionPanel;

    private ButtonPanel inputPanel;

    private String messageString = "消息区等待";

    private Icon messageIcon = new ImageIcon("ico/heart.jpg");

    private Object messageObject = new Date();

    private Component messageComponent = new JButton("组件消息");

    private JButton msgBn = new JButton("消息对话框");

    private JButton confirmBn = new JButton("确认对话框");

    private JButton inputBn = new JButton("输入对话框");

    private JButton optionBn = new JButton("选项对话框");

    public void init(){
        JPanel top = new JPanel();
        top.setBorder(new TitledBorder(new EtchedBorder(),"对话框的通用选项", TitledBorder.CENTER, TitledBorder.TOP));
        top.setLayout(new GridLayout(1, 2));
        messageTypePanel = new ButtonPanel("选择消息内容的类型", new String[]{"ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE"});
        messagePanel = new ButtonPanel("选择消息内容的类型", new String[]{"字符串消息", "图标消息", "组件消息", "普通对象消息", "Object[]消息"});
        top.add(messageTypePanel);
        top.add(messagePanel);
        JPanel bottom = new JPanel();
        bottom.setBorder(new TitledBorder(new EtchedBorder(), "弹出不同的对话框", TitledBorder.CENTER, TitledBorder.TOP));
        bottom.setLayout(new GridLayout(1, 4));
        msgPanel = new ButtonPanel("消息对话框", null);
        msgBn.addActionListener(new ShowAction());
        msgPanel.add(msgBn);
        confirmPanel = new ButtonPanel("确认对话框", new String[]{
                "DEFAULT_OPTION","YES_NO_OPTION", "YES_NO_CANCEL_OPTION" , "OK_CANCEL_OPTION"
        });
        confirmBn.addActionListener(new ShowAction());
        confirmPanel.add(confirmBn);
        inputPanel = new ButtonPanel("输入对话框", new String[]{"单行文本框", "下拉列表选择框"});
        inputBn.addActionListener(new ShowAction());
        inputPanel.add(inputBn);
        optionPanel = new ButtonPanel("选择对话框", new String[]{"字符串选项", "图表选项", "对象选项"});
        optionBn.addActionListener(new ShowAction());
        optionPanel.add(optionBn);
        bottom.add(msgPanel);
        bottom.add(confirmPanel);
        bottom.add(inputPanel);
        bottom.add(optionPanel);
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(top);
        box.add(bottom);
        jf.add(box);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    private int getOptionType(){
        switch (confirmPanel.getSelection()){
            case "DEFAULT_OPTION":
                return JOptionPane.DEFAULT_OPTION;
            case "YES_NO_OPTION":
                return JOptionPane.YES_NO_OPTION;
            case "YES_NO_CANCEL_OPTION":
                return JOptionPane.YES_NO_CANCEL_OPTION;
            default:
                return JOptionPane.OK_CANCEL_OPTION;
        }
    }

    private Object getMessage(){
        switch (messagePanel.getSelection()){
            case "字符串消息":
                return messageString;
            case "图标消息":
                return messageIcon;
            case "组件消息":
                return messageComponent;
            case "普通对象消息":
                return messageObject;
            default:
                return new Object[]{
                        messageString, messageIcon, messageComponent, messageObject
                };
        }
    }

    private int getDialogType(){
        switch (messageTypePanel.getSelection()){
            case "ERROR_MESSAGE":
                return JOptionPane.ERROR_MESSAGE;
            case "INFORMATION_MESSAGE":
                return JOptionPane.INFORMATION_MESSAGE;
            case "WARNING_MESSAGE":
                return JOptionPane.WARNING_MESSAGE;
            case "QUESTION_MESSAGE":
                return JOptionPane.QUESTION_MESSAGE;
            default:
                return JOptionPane.PLAIN_MESSAGE;
        }
    }

    private Object[] getOptions(){
        switch (optionPanel.getSelection()){
            case "字符串选项":
                return new String[]{"a", "b", "c", "d"};
            case "图表选项":
                return new Icon[]{
                        new ImageIcon("icon/1.gif"),
                        new ImageIcon("icon/2.gif"),
                        new ImageIcon("icon/3.gif"),
                        new ImageIcon("icon/4.gif")
                };
            default:
                return new Object[]{new Date(), new Date(), new Date()};
        }
    }

    private class ShowAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()){
                case "确认对话框":
                    JOptionPane.showConfirmDialog(jf, getMessage(), "确认对话框", getOptionType(), getDialogType());
                    break;
                case "输入对话框":
                    if (inputPanel.getSelection().equals("单行文本框")){
                        JOptionPane.showInputDialog(jf, getMessage(), "输入对话框", getDialogType());
                    }else {
                        JOptionPane.showInputDialog(jf, getMessage(), "输入对话框", getDialogType(), null,
                                new String[]{"轻量级Java ee企业应用实战", "疯狂jav讲义"}, "疯狂java讲义");
                    }
                    break;
                case "消息对话框":
                    JOptionPane.showMessageDialog(jf, getMessage(), "消息对话框", getDialogType());
                    break;
                case "选项对话框":
                    JOptionPane.showOptionDialog(jf, getMessage(), "选项对话框", getOptionType(), getDialogType(), null, getOptions(), "a");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new JOptionPaneTest().init();
    }

    class ButtonPanel extends JPanel{
        private ButtonGroup group;
        public ButtonPanel(String title, String[] options){
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            group = new ButtonGroup();
            for (int i = 0; options != null && i < options.length; i++){
                JRadioButton b = new JRadioButton(options[i]);
                b.setActionCommand(options[i]);
                add(b);
                group.add(b);
                b.setSelected(i == 0);
            }
        }
        public String getSelection(){
            return group.getSelection().getActionCommand();
        }
    }
}
