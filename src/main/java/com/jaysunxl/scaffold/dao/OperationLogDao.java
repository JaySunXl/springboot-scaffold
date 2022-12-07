package com.jaysunxl.scaffold.dao;

import com.jaysunxl.scaffold.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JaySunXl
 * @create 2022-10-10
 * @description
 */
@Mapper
public interface OperationLogDao {

    void insertOne(OperationLog log);

}
