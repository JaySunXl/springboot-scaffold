package com.jaysunxl.scaffold.service;

/**
 * @author sunxind
 * @date 2022-10-21
 */
public interface DataMaskingOperation {
    String MASK_CHAR = "*";
    String mask(String content,String maskChar);
}
