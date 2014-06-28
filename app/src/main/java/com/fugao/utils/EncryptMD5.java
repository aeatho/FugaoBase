package com.fugao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author liping
 *
 */
public class EncryptMD5 {
	 /*
     * 返回32位大写的MD5码
     */
	public static String getEncoderByMd5(String sessionid){
		StringBuffer hexString = null;
		byte[] defaultBytes = sessionid.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();
			hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				if (Integer.toHexString(0xFF & messageDigest[i]).length() == 1) {
					hexString.append(0);
				}
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			messageDigest.toString();
			sessionid = hexString + "";
		} catch (NoSuchAlgorithmException nsae) {

		}
		System.out.println(hexString.toString().toUpperCase());
		return hexString.toString().toUpperCase();

	}
}
