package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/03 18:26
 * @Description:
 **/
public class ChangeAllRender {

    JFrame jf = new JFrame("改变所有节点的外观");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");

    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");

    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");

    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");

    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");

    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");

    public void init(){
        guangdong.add(foshan);

        guangdong.add(shantou);

        guangxi.add(guilin);

        guangxi.add(nanning);

        root.add(guangdong);

        root.add(guangxi);

        tree = new JTree(root);

        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();

        cellRenderer.setBackgroundNonSelectionColor(new Color(220, 220, 220));

        cellRenderer.setBackgroundSelectionColor(new Color(140, 140, 140));

        cellRenderer.setBorderSelectionColor(Color.BLACK);

        cellRenderer.setClosedIcon(new ImageIcon("ico/close.gif"));

        cellRenderer.setFont(new Font("SansSerif", Font.BOLD, 16));

        cellRenderer.setLeafIcon(new ImageIcon("ico/leaf.png"));

        cellRenderer.setTextNonSelectionColor(new Color(225, 0, 0));

        cellRenderer.setTextSelectionColor(new Color(0, 0, 225));

        tree.setCellRenderer(cellRenderer);

        tree.setShowsRootHandles(true);

        jf.add(new JScrollPane());

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ChangeAllRender().init();
    }
}
