package com.jaysunxl.scaffold.annotation;

import com.jaysunxl.scaffold.constant.DataMaskingFunc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据面具 为敏感数据进行脱敏操作
 * @author JaySunXl
 * @date 2022-10-21
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;
}
