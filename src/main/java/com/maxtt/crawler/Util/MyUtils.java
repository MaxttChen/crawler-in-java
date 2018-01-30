package com.maxtt.crawler.Util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.maxtt.crawler.baiduTranslator.TransApi;

public class MyUtils {
	
	public static String Trans(String queryString,String fromLanguage,String toLanguage) {
		TransApi trans = new TransApi("20171107000093308","1o2zGhHIUFeDY1AkZYxy");
		
		//String result = trans.getTransResult("apple", "en", "zh");
		String result = trans.getTransResult(queryString,fromLanguage,toLanguage);
		
		//System.out.println(result);
		
		Map<String,Object> tr = JSON.parseObject(result,Map.class);
		
		JSONArray jarray = (JSONArray) tr.get("trans_result");
		
		Map<String,String> maps = JSON.parseObject(jarray.get(0).toString(),Map.class);
		
		System.out.println(maps.get("dst"));
		
		return maps.get("dst");
	}
}
