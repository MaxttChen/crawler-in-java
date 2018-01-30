package com.maxtt.crawler.demomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.maxtt.crawler.Util.MyUtils;


//test
public class demo1 {
	public static void main(String[] args) {
		//doGetDemo("http://www.baidu.com");
		MyUtils.Trans("apple", "en", "zh");
	}
	
	/***
	 * demo get request method.
	 */
	public static String doGetDemo(String strUrl) {
		
		BufferedReader br = null;
		
		StringBuffer sb = new StringBuffer();
		
		try {
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//模拟浏览器
			connection.setRequestProperty("accept","*/*");
			connection.setRequestProperty("connection","Keep-Alive");
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
			//连接
			connection.connect();
			//开启工作流
			br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String str ;
			while( (str = br.readLine() )!= null )
			{
				sb.append(str);
			}
			System.out.println(sb);
		} catch (Exception e) {
			System.out.println("创建URL失败");
			e.printStackTrace();
		}finally{
			if (br != null) {  
                try {  
                    br.close();  
                } catch (IOException e) {  
                    br = null;  
                    throw new RuntimeException(e);  
                }  
            } 
		}
		
		return sb.toString();
	}
	
}
