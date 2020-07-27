package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

/**
 * @Author: Richered
 * @Date: 2020/07/27 19:12
 * @Description:
 **/
public class JToolBarTest {
    JFrame jf = new JFrame("测试工具条");

    JTextArea jta = new JTextArea(6, 35);

    JToolBar jtb = new JToolBar();

    JMenuBar jmb = new JMenuBar();

    JMenu edit = new JMenu("编辑");

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    Action pasteAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                try {
                    String content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        }
    };

    Action copyAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection contents = new StringSelection(jta.getSelectedText());
            clipboard.setContents(contents, null);
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                pasteAction.setEnabled(true);
            }
        }
    };

    public void init(){
        pasteAction.setEnabled(false);
        jf.add(new JScrollPane(jta));
        JButton copyBn = new JButton(copyAction);
        JButton pasteBn = new JButton(pasteAction);
        JPanel jp = new JPanel();
        jp.add(copyBn);
        jp.add(pasteBn);
        jf.add(jp, BorderLayout.SOUTH);

        jtb.add(copyAction);
        jtb.add(pasteAction);

        edit.add(copyAction);
        edit.add(pasteAction);

        jmb.add(edit);
        jf.setJMenuBar(jmb);
        jtb.setMargin(new Insets(20, 10, 5, 30));

        jf.add(jta, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBarTest().init();
    }
}
