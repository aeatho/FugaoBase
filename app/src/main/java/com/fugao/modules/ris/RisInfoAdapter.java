package com.fugao.modules.ris;

import java.util.ArrayList;

import com.fugao.R;
import com.fugao.model.CheckApplyBean;
import com.fugao.utils.StringUtils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 检查申请适配器
 * 
 * @author gelp
 * 
 */
public class RisInfoAdapter extends BaseAdapter {
	private Activity mactivity;
	private ArrayList<CheckApplyBean> mapplyBeans;
	private LayoutInflater layoutInflater;
	private int selectPosition = -1;

	public RisInfoAdapter(Activity activity,
			ArrayList<CheckApplyBean> applyBeans) {
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
	public CheckApplyBean getItem(int arg0) {
		return mapplyBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder holder;
		if (arg1 == null) {
			holder = new ViewHolder();
			arg1 = layoutInflater.inflate(R.layout.fragment_ris_information,
					null);
			holder.risGroupRequestdate = (TextView) arg1
					.findViewById(R.id.ris_group_requestdate);
			holder.risGroupItemcode = (TextView) arg1
					.findViewById(R.id.ris_group_itemcode);
			holder.risLayout = (LinearLayout) arg1
					.findViewById(R.id.ris_information_layout);
			holder.risGroupImage = (ImageView) arg1
					.findViewById(R.id.ris_group_image);
			arg1.setTag(holder);
		} else {
			holder = (ViewHolder) arg1.getTag();
		}
		holder.risGroupRequestdate.setText(StringUtils.getString(mapplyBeans
				.get(arg0).getRequestDate()));
		holder.risGroupItemcode.setText(StringUtils.getString(mapplyBeans.get(
				arg0).getItemCode()));
		holder.risGroupImage.setBackgroundResource(R.drawable.arrow_normal);
		if (selectPosition == arg0) {
			holder.risLayout.setBackgroundColor(mactivity.getResources()
					.getColor(R.color.letfcheckbackground));
		} else {
			if (arg0 % 2 == 0) {
				holder.risLayout.setBackgroundColor(mactivity.getResources()
						.getColor(R.color.leftcontainerbackground));
			} else {
				holder.risLayout.setBackgroundColor(holder.risLayout
						.getResources().getColor(R.color.white));
			}
		}

		return arg1;
	}

	static class ViewHolder {
		TextView risGroupRequestdate;
		TextView risGroupItemcode;
		LinearLayout risLayout;
		ImageView risGroupImage;
	}

}
