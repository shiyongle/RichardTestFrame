package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Richered
 * @Date: 2020/07/29 12:57
 * @Description:
 **/
public class JTabbedPaneTest {
    JFrame jf = new JFrame("测试Tab页面");

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);

    ImageIcon icon = new ImageIcon("ico/close.gif");

    String[] layouts = {"换行布局", "滚动条布局"};

    String[] positions = {"左边", "顶部", "右边", "底部"};

    Map<String ,String> books = new LinkedHashMap<>();

    public void init(){
        books.put("疯狂java讲义", "java.png");
        books.put("轻量级java ee企业应用实战", "ee.png");
        books.put("疯狂ajax讲义", "ajax.png");
        books.put("疯狂android讲义", "android.png");
        books.put("经典java ee企业应用实战", "classic.png");

        String tip = "可看到本书的封面照片";
        for (String bookName: books.keySet()){
            tabbedPane.addTab(bookName, icon, null, tip);
        }

        jf.add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.addChangeListener(event ->{
            if (tabbedPane.getSelectedComponent() == null){
                int n = tabbedPane.getSelectedIndex();
                loadTab(n);
            }
        });
        loadTab(0);
        tabbedPane.setPreferredSize(new Dimension(500, 300));
        JPanel buttonPanel = new JPanel();
        ChangeAction action = new ChangeAction();
        buttonPanel.add(new ButtonPanel(action, "选择标签布局策略", layouts));
        buttonPanel.add(new ButtonPanel(action, "选择标签位置", positions));
        jf.add(buttonPanel, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public void loadTab(int n){
        String title = tabbedPane.getTitleAt(n);
        ImageIcon bookImage = new ImageIcon("icon/" + books.get(title));
        tabbedPane.setComponentAt(n, new JLabel(bookImage));
        tabbedPane.setIconAt(n, new ImageIcon("ico.open.gif"));
    }

    class ChangeAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            JRadioButton source = (JRadioButton) event.getSource();
            String selection = source.getActionCommand();
            if (selection.equals(layouts[0])){
                tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
            }else if (selection.equals(layouts[1])){
                tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            }else if (selection.equals(positions[0])){
                tabbedPane.setTabPlacement(JTabbedPane.LEFT);
            }else if (selection.equals(positions[1])){
                tabbedPane.setTabPlacement(JTabbedPane.TOP);
            }else if (selection.equals(positions[2])){
                tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
            }else if (selection.equals(positions[3])){
                tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
            }
        }
    }

    class ButtonPanel extends JPanel{
        private ButtonGroup group;

        public ButtonPanel(JTabbedPaneTest.ChangeAction action, String title, String[] labels){
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            group = new ButtonGroup();
            for (int i = 0; labels != null && i < labels.length; i++){
                JRadioButton b = new JRadioButton(labels[i]);
                add(b);
                b.addActionListener(action);
                group.add(b);
                b.setSelected(i == 0);
            }
        }
    }

    public static void main(String[] args) {
        new JTabbedPaneTest().init();
    }
}
