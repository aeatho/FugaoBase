package com.fugao.utils;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.TextView;
/**
 * 网络通信判断逻辑
 * @author findchen
 * TODO
 * 2013-8-13上午9:25:24
 */
public class NetWorkUtils {

	/**
	 * 判断网络情况
	 * @param context 上下文
	 * @return false 表示没有网络 true 表示有网络
	 */
	public static boolean isNetworkAvalible(Context context) {
		// 获得网络状态管理器
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivityManager == null) {
			return false;
		} else {
			// 建立网络数组
			NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();

			if (net_info != null) {
				for (int i = 0; i < net_info.length; i++) {
					// 判断获得的网络状态是否是处于连接状态
					if (net_info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// 如果没有网络，则弹出网络设置对话框
	public static void checkNetwork(final Activity activity) {
		if (!NetWorkUtils.isNetworkAvalible(activity)) {
			TextView msg = new TextView(activity);
			msg.setText("当前没有可以使用的网络，请设置网络！");
			new AlertDialog.Builder(activity)
					.setTitle("网络状态提示")
					.setView(msg)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int whichButton) {
									// 跳转到设置界面
									activity.startActivityForResult(new Intent(
											Settings.ACTION_WIRELESS_SETTINGS),
											0);
								}
							}).create().show();
		}
		return;
	}
	/**
	 * 连接指定ssid 的wife
	 * @Title: conectWifeBySSID 
	 * @Description: TODO
	 * @param activity
	 * @param ssid
	 * @param password
	 * @param type    网络类型
	 * @return: void
	 */
	public static void conectWifeBySSID(final Activity activity,final String ssid,final String password,final int type,final IConnetWife iConnetWife) {
		if (!NetWorkUtils.isNetworkAvalible(activity)) {
			TextView msg = new TextView(activity);
			msg.setText("推荐连接名称为： "+ssid+" 的无线网");
			new AlertDialog.Builder(activity)
					.setTitle("网络连接")
					.setView(msg).setNegativeButton("取消", new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog,
								int whichButton) {
							// 跳转到设置界面
							dialog.dismiss();
							iConnetWife.close();
						}
					}).setNegativeButton("网络设置", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							activity.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
						}
						
					})
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int whichButton) {
									// 跳转到设置界面
									WifiAdmin wifiAdmin=new WifiAdmin(activity);
									wifiAdmin.openWifi();
									wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo(ssid, password, type));
									iConnetWife.connect();
								}
							}).create().show();
		}
		return;
	}
	
	public interface IConnetWife{
		public void close();
		public void connect();
	}
}
