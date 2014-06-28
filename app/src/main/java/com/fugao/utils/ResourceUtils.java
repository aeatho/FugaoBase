package com.fugao.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
/**
 * 读取项目当中的资源
 * @author findchen_2013
 * 2013年11月18日下午3:21:30
 */
public class ResourceUtils {

	/**
	 * 从资源文件中的到数组内容
	 * @param context
	 * @param id
	 * @return
	 */
	public static String[] getResouce4Arrays(Context context,int id){
		String[] strings=null;
		
		strings=context.getResources().getStringArray(id);
		return strings;
	}
	/**
	 * 从资源文件中得到数据
	 * @param context
	 * @param id
	 * @return
	 */
	public static String getResouceString(Context context,int id){
		String strings=null;
		strings=context.getResources().getString(id);
		return strings;
	}
	
	
}
