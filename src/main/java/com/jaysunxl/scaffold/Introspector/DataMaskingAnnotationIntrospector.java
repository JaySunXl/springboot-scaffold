package com.jaysunxl.scaffold.Introspector;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.jaysunxl.scaffold.annotation.DataMasking;
import com.jaysunxl.scaffold.entity.DataMaskingSerializer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author JaySunXl
 * @date 2022-10-21
 */
@Slf4j
public class DataMaskingAnnotationIntrospector extends NopAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated am) {
        DataMasking dataMasking = am.getAnnotation(DataMasking.class);
        if (dataMasking !=null){
            return new DataMaskingSerializer(dataMasking.maskFunc().operation());
        }
        return null;
    }
}
