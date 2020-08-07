package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @Author: Richered
 * @Date: 2020/08/04 12:23
 * @Description:
 **/
public class CustomTreeNode {

    JFrame jf = new JFrame("定制树的节点");

    JTree tree;

    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suge = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎头");

    public void init(){
        friends.add(qingzhao);
        friends.add(suge);
        friends.add(libai);
        friends.add(nongyu);
        friends.add(hutou);

        tree = new JTree(friends);

        tree.setShowsRootHandles(true);

        tree.setRootVisible(true);

        tree.setCellRenderer(new ImageCellRenderer());

        jf.add(new JScrollPane());

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new CustomTreeNode().init();
    }
}
