package com.jaysunxl.scaffold.annotation;

import com.jaysunxl.scaffold.constant.OperationType;
import com.jaysunxl.scaffold.constant.OperationUnit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunxind
 * @create 2022-10-10
 * @description
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogDetail {
    String detail() default "";//方法描述，可使用占位符{{}}
    int level() default 0;//日志等级
    OperationType operationType() default OperationType.UNKNOWN;//操作类型
    OperationUnit operationUnit() default OperationUnit.UNKNOWN;//被操作的对象
}
