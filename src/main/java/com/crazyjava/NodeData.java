package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/08/03 18:41
 * @Description:
 **/
public class NodeData {

    public int nodeType;

    public String nodeData;

    public NodeData(int nodeType, String nodeData) {
        this.nodeData = nodeData;
        this.nodeType = nodeType;
    }

    public int getNodeType() {
        return nodeType;
    }

    public String getNodeData() {
        return nodeData;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public void setNodeData(String nodeData) {
        this.nodeData = nodeData;
    }
}
