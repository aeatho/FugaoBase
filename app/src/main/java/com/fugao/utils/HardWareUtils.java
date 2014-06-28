package com.fugao.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
/**
 * 硬件工具集
 * @author findchen
 * TODO
 * 2013-6-15下午5:19:30
 */
public class HardWareUtils {

	
	/**
	 * 得到 mac 地址
	 * @param context
	 * @return
	 */
	public static String getWifeMac(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		return info.getMacAddress();
	}
	/**
	 * 得到Android系统的sdk版本
	 * @return
	 */
	public static int  getAndroidOSSDK(){
		return android.os.Build.VERSION.SDK_INT;
	}
	/**
	 * 得到本机的ip地址
	 * @return
	 */
	public String getLocalIpAddress() {  
        try {  
            for (Enumeration<NetworkInterface> en = NetworkInterface  
                    .getNetworkInterfaces(); en.hasMoreElements();) {  
                NetworkInterface intf = en.nextElement();  
                for (Enumeration<InetAddress> enumIpAddr = intf  
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {  
                    InetAddress inetAddress = enumIpAddr.nextElement();  
                    if (!inetAddress.isLoopbackAddress()) {  
                        return inetAddress.getHostAddress().toString();  
                    }  
                }  
            }  
        } catch (SocketException ex) {  
            Log.e("WifiPreference IpAddress", ex.toString());  
        }  
        return null;  
    }  
   
}
