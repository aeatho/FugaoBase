package com.fugao.utils;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
/**
 * rest  模式 的 护理访问 控制层
 * @author findchen
 * TODO
 * 2013-5-24下午2:31:13
 */
public class RestClient {
	public static  String BASE_URL = "";
	//public static  String BASE_URL = "";
	
//	public static  String BASE_URL = "http://180.166.89.70:7999/";
	/**
	 * 网路请求接口
	 */
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	static {
		
		client.setTimeout(20000);
	};
	/**
	 * 将网路请求转换为 绝对地址
	 * @param relativeUrl
	 * @return
	 */
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
	/**
	 * 获取网络请求
	 * @param url					  url地址
	 * @param params				    请求参数	
	 * @param responseHandler		    异步请求的处理类	
	 */
	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), null, responseHandler);
		Log.d("get",getAbsoluteUrl(url) );
	}
	/**
	 * 登录url 	 
	 * @param url                      url地址   
	 * @param responseHandler		       
	 * @param context				      上下文
	 */
	public static void login(String url, AsyncHttpResponseHandler responseHandler,Context context) {
		client.get(getAbsoluteUrl(url), null, responseHandler);
		Log.d("login",getAbsoluteUrl(url) );
		PersistentCookieStore persistentCookieStore=new PersistentCookieStore(context);
		client.setCookieStore(persistentCookieStore);
	}
	/**
	 * 向服务器端发送数据
	 * @param context 					上行文
	 * @param url     					url地址
	 * @param jsonString 				json数据
	 * @param responseHandler			数据接收handler
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static void postJson(Context context, String url,
			String jsonString, AsyncHttpResponseHandler responseHandler)
		 {
		StringEntity entityJson;
		try {
			entityJson = new StringEntity(jsonString, HTTP.UTF_8);
			client.post(context, getAbsoluteUrl(url), entityJson, "application/json",
					responseHandler);
			Log.d("http",getAbsoluteUrl(url));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void delete(String url, AsyncHttpResponseHandler responseHandler){
		client.delete(getAbsoluteUrl(url), responseHandler);
	}

}
