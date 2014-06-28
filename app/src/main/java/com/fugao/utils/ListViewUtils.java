package com.fugao.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * ListView 的工具集(包括gridview 和listview的view 不展开问题)
 * 
 * @author findchen TODO 2013-6-15下午5:18:34
 */
public class ListViewUtils {

	/**
	 * 让listView的所有列展开
	 * 
	 * @param listView
	 *            目标listview
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

	/**
	 * 让gridview 的所有列展开
	 * 
	 * @param gridView
	 *            目标view
	 */
	@SuppressLint("NewApi")
	public static void setGridViewHeightBasedOnChildren(GridView gridView) {

		ListAdapter listAdapter = gridView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount()
				&& i < gridView.getNumColumns(); i++) {
			View listItem = listAdapter.getView(i, null, gridView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = gridView.getLayoutParams();
		params.height = totalHeight
				+ (gridView.getBottom() * (listAdapter.getCount() - 1));
		gridView.setLayoutParams(params);
	}
}
