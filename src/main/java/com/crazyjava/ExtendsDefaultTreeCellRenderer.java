package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.crypto.NodeSetData;

/**
 * @Author: Richered
 * @Date: 2020/08/03 18:39
 * @Description:
 **/
public class ExtendsDefaultTreeCellRenderer {

    JFrame jf = new JFrame("根据节点类型定义图标");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeData(DBObjectType.ROOT, "数据导航"));
    DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeData(DBObjectType.DATABASE, "公司工资数据库"));
    DefaultMutableTreeNode customerDv = new DefaultMutableTreeNode(new NodeData(DBObjectType.ROOT, "公司客户数据库"));
    DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "员工表"));
    DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "考勤表"));
    DefaultMutableTreeNode contact = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "联系方式表"));
    DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeData(DBObjectType.INDEX, "员工ID"));
    DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN, "姓名"));
    DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN, "性别"));

    public void init(){
        root.add(salaryDb);
        root.add(customerDv);
        salaryDb.add(employee);
        salaryDb.add(attend);
        customerDv.add(contact);
        employee.add(id);
        employee.add(name);
        employee.add(gender);

        tree = new JTree(root);

        tree.setCellRenderer(new MyRenderer());

        tree.setShowsRootHandles(true);

        tree.setRootVisible(true);

        try{
            UIManager.setLookAndFeel("com.sun,java.plat" + "windows.WindowsLookAndFeel");
        }catch (Exception ex){
        }

        SwingUtilities.updateComponentTreeUI(tree);

        jf.add(new JScrollPane(tree));

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ExtendsDefaultTreeCellRenderer().init();
    }
}
