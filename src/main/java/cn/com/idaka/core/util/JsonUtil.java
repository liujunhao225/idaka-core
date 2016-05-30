package cn.com.idaka.core.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil{

    public static String toJSONString(Object obj){
        return JSON.toJSONString(obj);
    }

    @SuppressWarnings("unchecked")
	public static <T> T parse(String s){
        if(s == null || s.length() <= 0 || s.equals("null"))
            return null;
       
        return (T)JSON.parse(s);
    }
}