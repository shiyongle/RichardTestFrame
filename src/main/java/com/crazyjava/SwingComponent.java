package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

/**
 * @Author: Richered
 * @Date: 2020/07/27 12:57
 * @Description:
 **/
public class SwingComponent {
    JFrame f = new JFrame("测试");

    Icon okIcon = new ImageIcon("icon/ok.png");

    JButton ok = new JButton("确认", okIcon);

    JRadioButton male = new JRadioButton("男", true);

    JRadioButton female = new JRadioButton("女", false);

    ButtonGroup bg = new ButtonGroup();

    JCheckBox married = new JCheckBox("是否已婚", false);

    String[] colors = new String[]{"红色","绿色","蓝色"};

    /**下拉框**/
    JComboBox<String> colorChooser = new JComboBox<>(colors);

    /**列表选择框**/
    JList<String> colorList = new JList<>(colors);

    /**8行20列的多行文本域**/
    JTextArea ta = new JTextArea(8, 20);

    /**40列的单行文本域**/
    JTextField name = new JTextField(40);
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("文件");
    JMenu edit = new JMenu("编辑");

    Icon newIcon = new ImageIcon("ico/new.png");
    JMenuItem newItem = new JMenuItem("新建", newIcon);

    Icon saveIcon = new ImageIcon("ico/save.png");
    JMenuItem saveItem = new JMenuItem("保存", saveIcon);

    JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");

    Icon exitIcon = new ImageIcon("ico/exit.png");
    JMenuItem exitItem = new JMenuItem("退出",exitIcon);
    JMenuItem copyItem = new JMenuItem("复制", new ImageIcon("ico/copy.png"));
    JMenuItem pasteItem = new JMenuItem("粘贴", new ImageIcon("ico/paste.png"));

    JMenu format = new JMenu("格式");
    JMenuItem commentItem = new JMenuItem("注释");
    JMenuItem cancelItem = new JMenuItem("取消注释");

    JPopupMenu pop = new JPopupMenu();
    ButtonGroup flavorGroup = new ButtonGroup();

    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal风格", true);
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus风格");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows风格");
    JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows经典风格");
    JRadioButtonMenuItem MotifItem = new JRadioButtonMenuItem("Motif经典风格");

    public void init(){
        JPanel bottom = new JPanel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);

        JPanel checkPanel = new JPanel();
        checkPanel.add(colorChooser);
        bg.add(male);
        bg.add(female);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        Box topLeft = Box.createVerticalBox();
        JScrollPane taJsp = new JScrollPane(ta);
        topLeft.add(taJsp);
        topLeft.add(checkPanel);

        Box top = Box.createVerticalBox();
        top.add(topLeft);
        top.add(colorList);

        f.add(top);

        newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        newItem.addActionListener(e -> ta.append("用户单击了”新建“菜单 \n"));

        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);

        commentItem.setToolTipText("将程序代码注释起来!");

        format.add(commentItem);
        format.add(cancelItem);

        edit.add(new JMenuItem("-"));
        edit.add(format);
        edit.add(file);

        mb.add(file);
        mb.add(edit);
        f.setJMenuBar(mb);

        flavorGroup.add(metalItem);
        flavorGroup.add(nimbusItem);
        flavorGroup.add(windowsItem);
        flavorGroup.add(classicItem);
        flavorGroup.add(MotifItem);

        pop.add(metalItem);
        pop.add(nimbusItem);
        pop.add(windowsItem);
        pop.add(classicItem);
        pop.add(MotifItem);

        ActionListener flavorListener = e -> {
            try {
                switch (e.getActionCommand()){
                    case "Metal风格":
                        changeFlavor(1);
                        break;
                    case "Nimbus风格":
                        changeFlavor(2);
                        break;
                    case "Windows风格":
                        changeFlavor(3);
                        break;
                    case "Windows经典风格":
                        changeFlavor(4);
                        break;
                    case "Motif经典风格":
                        changeFlavor(5);
                        break;
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }
        };

        metalItem.addActionListener(flavorListener);
        nimbusItem.addActionListener(flavorListener);
        windowsItem.addActionListener(flavorListener);
        classicItem.addActionListener(flavorListener);
        MotifItem.addActionListener(flavorListener);

        ta.setComponentPopupMenu(pop);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private void changeFlavor(int flavor) throws Exception{
        switch (flavor){
            case 1:
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFell");
                break;
            case 2:
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFell");
                break;
            case 3:
                UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFell");
                break;
            case 4:
                UIManager.setLookAndFeel("javax.swing.plaf.classic.ClassicLookAndFell");
                break;
            case 5:
                UIManager.setLookAndFeel("javax.swing.plaf.MotifItem.MotifLookAndFell");
                break;
        }
        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        SwingUtilities.updateComponentTreeUI(mb);
        SwingUtilities.updateComponentTreeUI(pop);
    }

    public static void main(String[] args) {
        new SwingComponent().init();
    }
}
