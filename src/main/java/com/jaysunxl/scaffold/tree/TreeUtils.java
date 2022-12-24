package com.jaysunxl.scaffold.tree;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/24
 */
public class TreeUtils {
    /**
     * 根据所有树节点列表，生成含有所有树形结构的列表
     *
     * @param nodes 树形节点列表
     * @param <T>   节点类型
     * @return 树形结构列表
     */
    public static <T extends TreeNode<?>> List<T> generateTrees(List<T> nodes) {
        List<T> roots = new ArrayList<>();
        for (Iterator<T> ite = nodes.iterator(); ite.hasNext(); ) {
            T node = ite.next();
            if (Objects.equals(node.getParentId(), 0L)) {
                roots.add(node);
                // 从所有节点列表中删除该节点，以免后续重复遍历该节点
                ite.remove();
            }
        }

        roots.forEach(root -> {
            setChildren(root, nodes);
        });
        return roots;
    }

    /**
     * 从所有节点列表中查找并设置parent的所有子节点
     *
     * @param parent 父节点
     * @param nodes  所有树节点列表
     */

    public static <T extends TreeNode> void setChildren(T parent, List<T> nodes) {
        List<T> children = new ArrayList<>();
        Object parentId = parent.getId();
        for (Iterator<T> ite = nodes.iterator(); ite.hasNext(); ) {
            T node = ite.next();
            if (Objects.equals(node.getParentId(), parentId)) {
                children.add(node);
                // 从所有节点列表中删除该节点，以免后续重复遍历该节点
                ite.remove();
            }
        }
        // 如果孩子为空，则直接返回,否则继续递归设置孩子的孩子
        if (CollectionUtils.isEmpty(children)) {
            return;
        }
        parent.setChildren(children);
        children.forEach(child -> {
            // 递归设置子节点
            setChildren(child, nodes);
        });
    }

    /**
     * 获取指定树节点下的所有叶子节点
     *
     * @param parent 父节点
     * @param <T>    实际节点类型
     * @return 叶子节点
     */
    public static <T extends TreeNode<?>> List<T> getLeafList(T parent) {
        List<T> leafList = new ArrayList<>();
        fillLeaf(parent, leafList);
        return leafList;
    }

    /**
     * 将parent的所有叶子节点填充至leafs列表中
     *
     * @param parent   父节点
     * @param leafList 叶子节点列表
     * @param <T>      实际节点类型
     */
    public static <T extends TreeNode> void fillLeaf(T parent, List<T> leafList) {
        List<T> children = Lists.newArrayList();
        // 如果节点没有子节点则说明为叶子节点
        if (CollectionUtils.isEmpty(children)) {
            leafList.add(parent);
            return;
        }
        // 递归调用子节点，查找叶子节点
        for (T child : children) {
            fillLeaf(child, leafList);
        }
    }
}
