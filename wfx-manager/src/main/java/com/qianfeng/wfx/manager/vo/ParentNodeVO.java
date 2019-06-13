package com.qianfeng.wfx.manager.vo;

import java.util.List;

public class ParentNodeVO {

    private String text;
    private List<LeafNodeVO> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<LeafNodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<LeafNodeVO> nodes) {
        this.nodes = nodes;
    }
}
