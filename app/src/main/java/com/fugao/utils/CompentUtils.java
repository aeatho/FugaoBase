package com.fugao.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
/**
 * 组件控制器
 * @author findchen
 * TODO
 * 2013-7-17下午7:10:56
 */
public class CompentUtils {
/**
 * 得到当前程序运行的哪一个activity ，哪一个activity 在最前面显示
 * @param context
 * @return
 */
	public static String getCurrentActivity(Context context) {
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
		RunningTaskInfo cinfo = runningTasks.get(0);
		ComponentName component = cinfo.topActivity;
		Log.e("currentactivity", component.getClassName());
		return component.getClassName();
	}
}
