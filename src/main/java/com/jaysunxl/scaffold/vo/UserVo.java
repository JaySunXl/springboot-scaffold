package com.jaysunxl.scaffold.vo;

import com.jaysunxl.scaffold.annotation.DataMasking;
import com.jaysunxl.scaffold.constant.DataMaskingFunc;

import java.io.Serializable;

/**
 * @author JaySunXl
 * @date 2022-10-21
 */
public class UserVo implements Serializable {

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String name;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String password;
}
