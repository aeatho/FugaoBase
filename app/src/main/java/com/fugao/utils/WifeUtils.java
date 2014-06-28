/**   
 * Copyright © 2014 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: WifeUtils.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.utils 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2014年3月7日 下午11:52:16 
 * @version: V1.0   
 */
package com.fugao.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * @ClassName: WifeUtils
 * @Description: TODO
 * @author: 陈亮 chenliang@fugao.com
 * @date: 2014年3月7日 下午11:52:16
 */
public class WifeUtils {
	private static WifiManager mWifi;
	private static WifiInfo wifiInfo;
	public static String getSSID(Context context) {
		 mWifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			wifiInfo = mWifi.getConnectionInfo(); 
		
		 return wifiInfo.getSSID().replace("\"", "");
	}
}
