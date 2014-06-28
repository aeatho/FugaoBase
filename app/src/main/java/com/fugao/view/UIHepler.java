/**   
 * Copyright © 2014 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: UIHepler.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.view 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2014年3月22日 下午6:50:29 
 * @version: V1.0   
 */
package com.fugao.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

/**
 * 界面帮助类，弹出警告对话框
 * 
 * @ClassName: UIHepler
 * @Description: TODO
 * @author: 陈亮 chenliang@fugao.com
 * @date: 2014年3月22日 下午6:50:29
 */
public class UIHepler {

	private static AlertDialog alertDialog;

	public static void showDilalog(Context context, String msg) {
		if (alertDialog == null || !alertDialog.isShowing()) {
			alertDialog = new AlertDialog.Builder(context).setTitle("提醒！")
					.setMessage(msg)
					.setPositiveButton("知道了", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					}).create();
			alertDialog.show();
		} else {
			alertDialog.setMessage(msg);
		}
	}

	public static void showToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

	}
}
