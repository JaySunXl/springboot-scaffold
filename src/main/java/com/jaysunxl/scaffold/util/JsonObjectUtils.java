package com.jaysunxl.scaffold.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/9
 */
public class JsonObjectUtils {

    /**
     * 所有的key转换为驼峰式
     *
     * @param jsonObject
     * @return
     */
    public static String toLowerCase(JSONObject jsonObject) {
        JSONObject ret = new JSONObject();
        Set<String> keySet = jsonObject.keySet();
        for (String key : keySet) {
            Object value = jsonObject.get(key);
            String lowerCamelKey = StringUtils.toLowerCamel2(key);
            ret.put(lowerCamelKey, value);
        }
        System.out.println(ret);
        return JSONObject.toJSONString(ret);
    }

}
