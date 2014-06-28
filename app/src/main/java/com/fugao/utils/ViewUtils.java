package com.fugao.utils;

import android.view.View;

/**
 * view 操作工具集
 * @author findchen
 * TODO
 * 2013-7-17下午4:43:56
 */
public class ViewUtils {
	/**
	 * View 可见
	 * @param v
	 */
	public static void setVisible(View v) {
		if(v.getVisibility()==View.GONE||v.getVisibility()==View.INVISIBLE){
			v.setVisibility(View.VISIBLE);
		}
	}
	/**
	 * view 消失不可见
	 * @param v
	 */
	public static void setGone(View v) {
		if(v.getVisibility()==View.VISIBLE){
			v.setVisibility(View.GONE);
		}
	}
	
	/**
	 * view 消失不可见并且占住位置
	 * @param v
	 */
	public static void setInVisible(View v) {
		if(v.getVisibility()==View.VISIBLE){
			v.setVisibility(View.INVISIBLE);
		}
	}
}
