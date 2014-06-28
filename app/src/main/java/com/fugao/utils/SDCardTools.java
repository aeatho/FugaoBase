package com.fugao.utils;

import android.os.Environment;

/**
 * SD card的操作相关
 * 
 */
public class SDCardTools {
	/**
	 * 得到SD卡的路径
	 * 
	 * @return
	 */
	public static String getSDPath() {
		return Environment.getExternalStorageDirectory().getPath();
	}

	/**
	 * 判断是否插入sdk
	 */
	public static boolean hasSdk() {
		boolean flag = false;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}
}
