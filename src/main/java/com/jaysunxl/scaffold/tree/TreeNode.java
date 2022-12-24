package com.jaysunxl.scaffold.tree;

import java.util.List;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/24
 */
public interface TreeNode<T> {
    /**
     * 获取节点id
     *
     * @return 树节点id
     */
    Long getId();

    /**
     * 获取该节点的父节点id
     *
     * @return 父节点id
     */
    Long getParentId();

    /**
     * 设置节点的子节点列表
     *
     * @param children 子节点
     */
    void setChildren(List<T> children);

}
