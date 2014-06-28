/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: LisResultAdapter.java 
 * @Prject: FugaoNurse
 * @Package: com.fugao.nurse.adapter 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2013年12月13日 上午10:26:05 
 * @version: V1.0   
 */
package com.fugao.modules.lis;

import java.util.ArrayList;

import com.fugao.R;
import com.fugao.model.InspectResultBean;
import com.fugao.utils.StringUtils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/** 
 * @ClassName: LisResultAdapter 
 * @Description: TODO list 结果展示列表
 * @author: 陈亮    chenliang@fugao.com 修改结果
 * @date: 2013年12月13日 上午10:26:05  
 */
public class LisResultAdapter extends BaseAdapter{

	private Activity mactivity;
	private ArrayList<InspectResultBean> mresultBeans;
	private LayoutInflater layoutInflater;
	private ViewChildHolder childHolder;

	public LisResultAdapter(Activity activity,
			ArrayList<InspectResultBean> resultBeans) {
		this.mactivity = activity;
		this.layoutInflater = LayoutInflater.from(mactivity);
		this.mresultBeans = resultBeans;
	}

	@Override
	public int getCount() {
		return mresultBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mresultBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		if (convertView == null) {
			childHolder = new ViewChildHolder();
			convertView = layoutInflater.inflate(
					R.layout.fragment_lis_child_item, null);
			childHolder.lisChildItemcode = (TextView) convertView
					.findViewById(R.id.textView_lis_result_itemcode);
			childHolder.lisChildItemname = (TextView) convertView
					.findViewById(R.id.textView_lis_result_itemname);
			childHolder.lisChildValue = (TextView) convertView
					.findViewById(R.id.textView_lis_result_value);
			childHolder.lisChildRefrange = (TextView) convertView
					.findViewById(R.id.textView_lis_result_refrange);
			childHolder.lisChildConclusion = (TextView) convertView
					.findViewById(R.id.textView_lis_result_conclusion);
			childHolder.lisResultProgressbar = (ProgressBar) convertView
					.findViewById(R.id.lis_result_progressbar);
			childHolder.lisItemLayout = (LinearLayout) convertView
					.findViewById(R.id.lis_item_layout);
			childHolder.lisResultRefrangeLayout = (LinearLayout) convertView
					.findViewById(R.id.lis_result_refrange_layout);
			convertView.setTag(childHolder);
		} else {
			childHolder = (ViewChildHolder) convertView.getTag();
		}

		InspectResultBean inspectResultBean = mresultBeans.get(arg0);
		if (StringUtils.StringIsEmpty(inspectResultBean.getSampleNo())) {
			childHolder.lisItemLayout.setVisibility(View.GONE);
			childHolder.lisResultProgressbar.setVisibility(View.VISIBLE);
		} else {
			childHolder.lisItemLayout.setVisibility(View.VISIBLE);
			childHolder.lisResultProgressbar.setVisibility(View.GONE);
		}
		childHolder.lisChildItemcode.setText(StringUtils
				.getString(inspectResultBean.getItemCode()));
		childHolder.lisChildItemname.setText(StringUtils
				.getString(inspectResultBean.getItemName()));
		childHolder.lisChildRefrange.setText(StringUtils
				.getString(inspectResultBean.getRefRange()));
		if (!StringUtils.StringIsEmpty(inspectResultBean.getConclusion())) {
			if (inspectResultBean.getConclusion().trim().equals("M")) {
				childHolder.lisChildConclusion.setVisibility(View.GONE);
				childHolder.lisChildValue.setTextColor(mactivity.getResources()
						.getColor(R.color.red));
			} else {
				childHolder.lisChildConclusion.setTextColor(mactivity
						.getResources().getColor(R.color.red));
				childHolder.lisChildConclusion.setText(StringUtils
						.getString(inspectResultBean.getConclusion()));
				childHolder.lisChildValue.setTextColor(mactivity.getResources()
						.getColor(R.color.black));
				childHolder.lisChildConclusion.setVisibility(View.VISIBLE);
			}
		} else {
			childHolder.lisChildValue.setTextColor(mactivity.getResources()
					.getColor(R.color.black));
			childHolder.lisChildConclusion.setVisibility(View.GONE);
		}
		childHolder.lisChildValue.setText(StringUtils
				.getString(inspectResultBean.getValue()));
		if (StringUtils.getString(inspectResultBean.getRefRange()).trim()
				.equals("")) {
			childHolder.lisResultRefrangeLayout.setVisibility(View.GONE);
		} else {
			childHolder.lisResultRefrangeLayout.setVisibility(View.VISIBLE);
		}
		
		if (arg0 % 2 == 0) {
			childHolder.lisItemLayout.setBackgroundColor(mactivity
					.getResources().getColor(R.color.split_up));
		} else {
			childHolder.lisItemLayout.setBackgroundColor(mactivity
					.getResources().getColor(R.color.white));
		}

		return convertView;
	}

	static class ViewChildHolder {
		TextView lisChildItemcode;
		TextView lisChildItemname;
		TextView lisChildValue;
		TextView lisChildRefrange;
		TextView lisChildConclusion;
		ProgressBar lisResultProgressbar;
		LinearLayout lisItemLayout;
		LinearLayout lisResultRefrangeLayout;
	}

}
