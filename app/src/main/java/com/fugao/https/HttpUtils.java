package com.fugao.https;

import org.apache.http.NameValuePair;

import android.content.Context;
import android.util.Log;

public class HttpUtils {
	// 网络连接部分
	public static String postByHttpURLConnection(String strUrl,
			NameValuePair... nameValuePairs) {
		return CustomHttpURLConnection.PostFromWebByHttpURLConnection(strUrl,
				nameValuePairs);
	}

	public static String getByHttpURLConnection(String strUrl,
			NameValuePair... nameValuePairs) {
		return CustomHttpURLConnection.GetFromWebByHttpUrlConnection(strUrl,
				nameValuePairs);
	}


	// ------------------------------------------------------------------------------------------
	// 网络连接判断
	// 判断是否有网络
//	public static boolean isNetworkAvailable(Context context) {
//		return NetWorkHelper.isNetworkAvailable(context);
//	}
}
