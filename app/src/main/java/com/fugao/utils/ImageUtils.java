package com.fugao.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageUtils {

	/**
	 * 通过资源文件的名称来加载图片，
	 * 1.如果没找到此张图片，则以系统图片代替
	 * @param contex
	 * @param name
	 * @return
	 */
	public static int getResIDByName(Context contex, String name) {

		int id = contex.getResources().getIdentifier(
				name.toLowerCase(Locale.getDefault()), "drawable",
				contex.getPackageName());
		if (id == 0) {
			id = getResIDByName(contex, "clock_12");
		}
		return id;

	}
	
	/**
	 * bitmap转为base64
	 * @param bitmap
	 * @return
	 */
	public static String bitmapToBase64(Bitmap bitmap) {

		String result = null;
		ByteArrayOutputStream baos = null;
		try {
			if (bitmap != null) {
				baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

				baos.flush();
				baos.close();

				byte[] bitmapBytes = baos.toByteArray();
				result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.flush();
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * base64转为bitmap
	 * @param base64Data
	 * @return
	 */
	public static Bitmap base64ToBitmap(String base64Data) {
		byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
		return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	}
	

	public Bitmap getBitmapFromByte(byte[] temp) {

		if (temp != null) {
			BitmapFactory.Options opt = new BitmapFactory.Options();
			opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
			Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length, opt);
			if(bitmap!=null){
				return bitmap;
			}else {
				return null;
			}
			
//			Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length);

		} else {

			return null;

		}
	}
}
