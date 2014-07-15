package com.fm.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	public static String Object2Json(Object obj){
		return JSON.toJSONString(obj);
	}
	
}
