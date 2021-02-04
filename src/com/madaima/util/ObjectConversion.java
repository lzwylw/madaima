package com.madaima.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JiaBin.Wang
 * @className ObjectConversion
 * @date 2020/11/12 3:15 下午
 * @deacription copy集合
 **/
public class ObjectConversion {

    /**
     * 转换request 请求参数(getParameterMap())
     * @param paramMap request获取的参数数组
     */
    public static Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }
}
