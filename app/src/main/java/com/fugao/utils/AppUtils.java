package com.fugao.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

/**
 * 系统相关的内容
 * 
 * @author findchen  2013-9-9上午11:08:04
 */
public class AppUtils {

	/**
	 * 得到当前的程序的版本号
	 * 
	 * @param mContext
	 * @return
	 */
	public static int getCurrentVersion(Context mContext) {
		int curVersionCode = 0;
		try {
			PackageInfo info = mContext.getPackageManager().getPackageInfo(
					mContext.getPackageName(), 0);

			curVersionCode = info.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace(System.err);
		}
		return curVersionCode;
	}

	public static String getCurrentVersionName(Context mContext) {
		String versionName = "";
		try {
			PackageInfo info = mContext.getPackageManager().getPackageInfo(
					mContext.getPackageName(), 0);

			versionName = info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace(System.err);
		}
		return versionName;
	}
	/**
	 * 得到manifest         文件中的 meta 标签中的数据
	 * @param mContext   
	 * @param key          meta 对应的key
	 * @return
	 */
	public static String getMetaData(Context mContext,String key){
		String value="";
		ApplicationInfo appInfo;
		try {
			appInfo = mContext.getPackageManager()
			        .getApplicationInfo(mContext.getPackageName(), 
			PackageManager.GET_META_DATA);
			value=appInfo.metaData.getString(key);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	
	}
	
	public static void uninstallApp(Context context,String packageName){
		Uri packageURI = Uri.parse("package:"+packageName);     
		Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);     
		context.startActivity(uninstallIntent);  
	}
	
	
	  
	
}
