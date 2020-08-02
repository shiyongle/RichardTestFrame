package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @Author: Richered
 * @Date: 2020/08/02 22:05
 * @Description:
 **/
public class SimpleJTree {
    JFrame jf = new JFrame("简单树");

    JTree tree;

    DefaultMutableTreeNode root;

    DefaultMutableTreeNode guangdong;

    DefaultMutableTreeNode guangxi;

    DefaultMutableTreeNode foshan;

    DefaultMutableTreeNode shantou;

    DefaultMutableTreeNode guilin;

    DefaultMutableTreeNode nanning;

    public void init(){
        root = new DefaultMutableTreeNode("中国");
        guangdong = new DefaultMutableTreeNode("广东");
        guangxi = new DefaultMutableTreeNode("广西");
        foshan = new DefaultMutableTreeNode("佛山");
        shantou = new DefaultMutableTreeNode("汕头");
        guilin = new DefaultMutableTreeNode("桂林");
        nanning = new DefaultMutableTreeNode("南宁");

        guangdong.add(foshan);

        guangdong.add(shantou);

        guangxi.add(guilin);

        guangxi.add(nanning);

        root.add(guangdong);

        root.add(guangxi);

        tree = new JTree(root);

        jf.add(new JScrollPane(tree));

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleJTree().init();
    }
}
