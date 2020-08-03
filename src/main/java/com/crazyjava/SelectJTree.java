package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * @Author: Richered
 * @Date: 2020/08/03 18:16
 * @Description:
 **/
public class SelectJTree {
    JFrame jf = new JFrame("监听树的选择事件");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");

    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");

    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");

    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");

    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");

    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");

    JTextArea eventTxt = new JTextArea(5, 20);

    public void init(){
        guangdong.add(foshan);

        guangdong.add(shantou);

        guangxi.add(guilin);

        guangxi.add(nanning);

        root.add(guangxi);

        root.add(guangdong);

        tree = new JTree(root);

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(e -> {
            if (e.getOldLeadSelectionPath() != null){
                eventTxt.append("原选中的节点路径：" + e.getOldLeadSelectionPath().toString() + "\n");
                eventTxt.append("新选中的节点路径:" + e.getNewLeadSelectionPath().toString() + "\n");
            }
        });

        tree.setShowsRootHandles(true);

        tree.setRootVisible(true);

        Box box = new Box(BoxLayout.X_AXIS);

        box.add(new JScrollPane(tree));

        box.add(new JScrollPane(eventTxt));

        jf.add(box);

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectJTree().init();
    }
}
