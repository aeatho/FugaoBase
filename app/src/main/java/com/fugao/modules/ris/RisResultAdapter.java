package com.fugao.modules.ris;

import java.util.ArrayList;

import com.fugao.R;
import com.fugao.model.CheckResultBean;
import com.fugao.utils.StringUtils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 检查结果适配器
 * @author gelp
 *
 */
public class RisResultAdapter extends BaseAdapter {

	private Activity mactivity;
	private ArrayList<CheckResultBean> mresultBeans;
	private LayoutInflater layoutInflater;

	public RisResultAdapter(Activity activity,
			ArrayList<CheckResultBean> resultBeans) {
		this.mactivity = activity;
		this.layoutInflater = LayoutInflater.from(mactivity);
		this.mresultBeans = resultBeans;
	}

	@Override
	public int getCount() {
		return mresultBeans.size();
	}

	@Override
	public CheckResultBean getItem(int arg0) {
		return mresultBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder holder;
		if (arg1 == null) {
			holder = new ViewHolder();
			arg1 = layoutInflater.inflate(R.layout.fragment_ris_labor, null);
			holder.lisType = (TextView) arg1.findViewById(R.id.lis_child_type);
			holder.lisPort = (TextView) arg1.findViewById(R.id.lis_child_port);
			holder.lisExamtech = (TextView) arg1
					.findViewById(R.id.lis_child_examtech);
			holder.lisClinicdiag = (TextView) arg1
					.findViewById(R.id.lis_child_clinicdiag);
			holder.lisContent = (TextView) arg1
					.findViewById(R.id.lis_child_content);
			holder.lisValue = (TextView) arg1
					.findViewById(R.id.lis_child_value);
			holder.lisReportdate = (TextView) arg1
					.findViewById(R.id.lis_child_reportdate);
			holder.lisVerifydoctor = (TextView) arg1
					.findViewById(R.id.lis_child_verifydoctor);
			arg1.setTag(holder);
		} else {
			holder = (ViewHolder) arg1.getTag();
		}
		CheckResultBean checkResultBean = mresultBeans.get(arg0);
		holder.lisType.setText(StringUtils.getString(checkResultBean
				.getItemCode()));
		holder.lisPort.setText(StringUtils.getString(checkResultBean
				.getItemName()));
		holder.lisExamtech.setText(StringUtils.getString(checkResultBean
				.getExamTech()));
		holder.lisClinicdiag.setText(StringUtils.getString(checkResultBean
				.getClinicDiag()));
		holder.lisContent.setText(StringUtils.getString(checkResultBean
				.getContent()));
		holder.lisValue.setText(StringUtils.getString(checkResultBean
				.getDiagResult()));
		holder.lisReportdate.setText(StringUtils.getString(checkResultBean
				.getReportDate()));
		holder.lisVerifydoctor.setText(StringUtils.getString(checkResultBean
				.getVerifyDoctor()));
		return arg1;
	}

	static class ViewHolder {
		TextView lisType;
		TextView lisPort;
		TextView lisExamtech;
		TextView lisClinicdiag;
		TextView lisContent;
		TextView lisValue;
		TextView lisReportdate;
		TextView lisVerifydoctor;
	}

}
