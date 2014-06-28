/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: PullXMLTools.java 
 * @Prject: FugaoNurse
 * @Package: com.fugao.nurse.utils 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2013年12月13日 下午3:38:18 
 * @version: V1.0   
 */
package com.fugao.utils;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;
/** 
 * @ClassName: PullXMLTools 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2013年12月13日 下午3:38:18  
 */
public class PullXMLTools {
	/**
	 * 解析xml文件
	 * 
	 * @Title: parseXml
	 * @Description: TODO
	 * @param context
	 * @param xmlID
	 *            xml文件的int值
	 * @param tagIDNam
	 *            节点中 属性为id的值
	 * @return
	 */
	public static String parseXml(Context context, int xmlID, String tagIDNam) {
		String response = "";
		XmlResourceParser xrp = context.getResources().getXml(xmlID);
		try {
			// 直到文档的结尾处
			while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
				// 如果遇到了开始标签
				if (xrp.getEventType() == XmlResourceParser.START_TAG) {
					String tagName = xrp.getName();// 获取标签的名字
					if ("module".equals(tagName)) {
						String id = xrp.getAttributeValue(null, "id");// 通过属性名来获取属性值
						if (tagIDNam.equals(id)) {
							response = xrp.nextText();
						}

					}
				}
				xrp.next();// 获取解析下一个事件
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
}
