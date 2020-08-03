package com.crazyjava;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/03 18:43
 * @Description:
 **/
public class MyRenderer extends DefaultTreeCellRenderer {

    ImageIcon rootIcon = new ImageIcon("icon/root.gif");

    ImageIcon databaseIcon = new ImageIcon("icon/database.gif");

    ImageIcon tableIcon = new ImageIcon("icon/table.gif");

    ImageIcon columnIcon = new ImageIcon("icon/column.gif");

    ImageIcon indexIcon = new ImageIcon("icon/index.gif");

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        NodeData data = (NodeData) node.getUserObject();

        ImageIcon icon = null;

        switch (data.nodeType){
            case DBObjectType.ROOT:
                icon = rootIcon;
                break;
            case DBObjectType.DATABASE:
                icon = databaseIcon;
                break;
            case DBObjectType.TABLE:
                icon = tableIcon;
                break;
            case DBObjectType.INDEX:
                icon = indexIcon;
                break;
        }
        this.setIcon(icon);
        return this;
    }
}
