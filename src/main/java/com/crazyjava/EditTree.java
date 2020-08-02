package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author: Richered
 * @Date: 2020/08/02 22:11
 * @Description:
 **/
public class EditTree {

    JFrame jf;

    JTree tree;

    DefaultTreeModel model;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");

    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");

    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");

    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");

    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");

    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");

    TreePath movePath;

    JButton addSiblingButton = new JButton("添加兄弟节点");

    JButton addChildButton = new JButton("添加子节点");

    JButton deleteButton = new JButton("删除节点");

    JButton editButton = new JButton("编辑当前节点");


    public void init(){
        guangdong.add(foshan);

        guangdong.add(shantou);

        guangxi.add(guilin);

        guangxi.add(nanning);

        root.add(guangxi);

        root.add(guangdong);

        jf = new JFrame("可编辑的节点的树");

        tree = new JTree(root);

        model = (DefaultTreeModel) tree.getModel();

        tree.setEditable(true);

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null){
                    movePath = tp;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null && movePath != null){
                    if (movePath.isDescendant(tp) && movePath != tp){
                        JOptionPane.showMessageDialog(jf, "目标节点是被移动节点的子节点，无法移动！", "非法操作",JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if (movePath != tp){
                        ((DefaultMutableTreeNode)tp.getLastPathComponent()).add((DefaultMutableTreeNode) movePath.getLastPathComponent());
                        movePath = null;
                        tree.updateUI();
                    }
                }
            }
        };
        tree.addMouseListener(ml);
        JPanel panel = new JPanel();
        addSiblingButton.addActionListener(event ->{
            DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectNode == null){
                return;
            }
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectNode.getParent();
            if (panel == null){
                return;
            }
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");

            int selectedIndex = parent.getIndex(selectNode);

            model.insertNodeInto(newNode, parent, selectedIndex + 1);

            TreeNode[] nodes = model.getPathToRoot(newNode);

            TreePath path = new TreePath(nodes);

            tree.scrollPathToVisible(path);
        });

        panel.add(addSiblingButton);

        addChildButton.addActionListener(event -> {
            DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectNode == null){
                return;
            }
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");

            selectNode.add(newNode);

            TreeNode[] nodes = model.getPathToRoot(newNode);

            TreePath path = new TreePath(nodes);

            tree.scrollPathToVisible(path);

            tree.updateUI();
        });

        panel.add(addChildButton);

        deleteButton.addActionListener(event ->{
            DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectNode != null && selectNode.getParent() != null){
                model.removeNodeFromParent(selectNode);
            }
        });

        panel.add(deleteButton);

        editButton.addActionListener(event ->{
            TreePath selectPath = tree.getSelectionPath();
            if (selectPath != null) {
                tree.startEditingAtPath(selectPath);
            }
        });

        panel.add(editButton);

        jf.add(new JScrollPane(tree));

        jf.add(panel, BorderLayout.SOUTH);

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new EditTree().init();
    }
}
