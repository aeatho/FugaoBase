/**   
 * Copyright © 2013 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: LisItemAdapter.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.modules
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2013年12月13日 上午9:47:47 
 * @version: V1.0   
 */
package com.fugao.modules.lis;
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fugao.R;
import com.fugao.model.InspectApplyBean;
import com.fugao.utils.StringUtils;
/** 
 * @ClassName: LisItemAdapter 
 * @Description: TODO 检验条目数据 适配器
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2013年12月13日 上午9:47:47  
 */
public class LisItemAdapter extends BaseAdapter{
	private Activity mactivity;
	private ArrayList<InspectApplyBean> mapplyBeans;
	private LayoutInflater layoutInflater;
	private ViewGroupHolder groupHolder;
	private int selectPosition = -1;

	public LisItemAdapter(Activity activity,
			ArrayList<InspectApplyBean> applyBeans) {
		this.mactivity = activity;
		this.mapplyBeans = applyBeans;
		this.layoutInflater = LayoutInflater.from(mactivity);
	}

	public void selectView(int index) {
		this.selectPosition = index;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {

		return mapplyBeans.size();
	}

	@Override
	public InspectApplyBean getItem(int arg0) {
		return mapplyBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		if (convertView == null) {
			groupHolder = new ViewGroupHolder();
			convertView = layoutInflater.inflate(
					R.layout.fragment_lis_information_item, null);
			groupHolder.lisGroupDate = (TextView) convertView
					.findViewById(R.id.textView_lis_restdate);
			groupHolder.lisGroupType = (TextView) convertView
					.findViewById(R.id.textView_lis_type);
			groupHolder.lisGroupDiagnosis = (TextView) convertView
					.findViewById(R.id.textView_lis_diagnosis);
			groupHolder.lisGroupLayout = (LinearLayout) convertView
					.findViewById(R.id.lisGroupLayout);
			groupHolder.lisImage = (ImageView) convertView
					.findViewById(R.id.lis_image);
			convertView.setTag(groupHolder);
		} else {
			groupHolder = (ViewGroupHolder) convertView.getTag();
		}
		InspectApplyBean applyBean = mapplyBeans.get(arg0);
		groupHolder.lisGroupDate.setText(StringUtils.StringIsEmpty(applyBean
				.getRequestDate()) ? "" : applyBean.getRequestDate().substring(
				0, 10));
		groupHolder.lisGroupType.setText(StringUtils.getString(applyBean
				.getType()));
		groupHolder.lisGroupDiagnosis.setText(StringUtils.getString(applyBean
				.getDiagnosis()));

		if (selectPosition == arg0) {
			groupHolder.lisGroupLayout.setBackgroundColor(mactivity
					.getResources().getColor(R.color.letfcheckbackground));
		} else {
			if (arg0 % 2 == 0) {
				groupHolder.lisGroupLayout.setBackgroundColor(mactivity
						.getResources().getColor(R.color.split_up));
			} else {
				groupHolder.lisGroupLayout.setBackgroundColor(mactivity
						.getResources().getColor(R.color.white));
			}
		}
		groupHolder.lisImage.setBackgroundResource(R.drawable.arrow_normal);
		return convertView;
	}

	static class ViewGroupHolder {
		TextView lisGroupDate;
		TextView lisGroupType;
		TextView lisGroupDiagnosis;
		LinearLayout lisGroupLayout;
		ImageView lisImage;
	}
}
