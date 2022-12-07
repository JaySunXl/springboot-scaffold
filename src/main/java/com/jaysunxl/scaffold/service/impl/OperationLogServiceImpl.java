package com.jaysunxl.scaffold.service.impl;

import com.jaysunxl.scaffold.dao.OperationLogDao;
import com.jaysunxl.scaffold.entity.OperationLog;
import com.jaysunxl.scaffold.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JaySunXl
 * @create 2022-10-10
 * @description
 */
@Service(value = "operationLogService")
public class OperationLogServiceImpl implements IOperationLogService {
    @Autowired
    private OperationLogDao logDao;

    @Override
    public void insertOne(OperationLog operationLog) {
        logDao.insertOne(operationLog);
    }
}
