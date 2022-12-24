package com.jaysunxl.scaffold.tree;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/24
 */
@Data
public class RoleTreeVO implements TreeNode<RoleTreeVO> {

    private Long parentId;

    private Long id;


    private String name;


    private String enName;

    private String description;

    private List<RoleTreeVO> children;

}

