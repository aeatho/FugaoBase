/**   
 * Copyright © 2014 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: ViewHolder.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.utils 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2014年1月20日 下午2:58:58 
 * @version: V1.0   
 */
package com.fugao.utils;

import android.util.SparseArray;
import android.view.View;

/** 
 * @ClassName: ViewHolder 
 * @Description: TODO  adapter 里面实现viewholder 方案
 * 
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2014年1月20日 下午2:58:58  
 */
public class ViewHolder {
	/**
	 * 
	 * @Title: get 
	 * @Description: TODO
	 * @param view    currentview
	 * @param id      资源记录
	 * @return
	 * @return: T
	 */
	public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
