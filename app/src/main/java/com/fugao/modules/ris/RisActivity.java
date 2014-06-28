package com.fugao.modules.ris;

import java.util.ArrayList;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.fugao.R;
import com.fugao.base.BaseTempleActivity;
import com.fugao.constant.PublicApi;
import com.fugao.constant.ReportApi;
import com.fugao.model.CheckApplyBean;
import com.fugao.model.CheckResultBean;
import com.fugao.model.PatientBean;
import com.fugao.utils.RestClient;
import com.fugao.utils.String2Model;
import com.fugao.utils.StringUtils;
import com.fugao.view.SlidingLayer;
import com.loopj.android.http.AsyncHttpResponseHandler;

@Deprecated
public class RisActivity extends BaseTempleActivity {
	/**
	 * 检查申请
	 */
	private ListView risInformation;

	/**
	 * 检查申请界面
	 */
	private LinearLayout risInformationLayout;
	/**
	 * 重新访问
	 */
	private Button risInforUnweb;

	/**
	 * 检查申请进度条
	 */
	private ProgressBar progressBarRisInformation;

	/**
	 * 检查申请数据集合
	 */
	private ArrayList<CheckApplyBean> applyBeans;

	/**
	 * 检查申请适配器
	 */
	private RisInfoAdapter risInfoAdapter;

	/**
	 * 检查结果列表
	 */
	private ListView risResult;
	/**
	 * 检查结果界面
	 */
	private LinearLayout risResultLayout;
	/**
	 * 重新访问
	 */
	private Button risResultUnweb;
	/**
	 * 检查结果进度条
	 */
	private ProgressBar progressBarRisResult;
	/**
	 * 检查结果数据集合
	 */
	private ArrayList<CheckResultBean> resultBeans;
	/**
	 * 检查结果适配器
	 */
	private RisResultAdapter risResultAdapter;

	/**
	 * 当前病人
	 */
	public PatientBean currentPatientBean;
	/**
	 * 病人住院号
	 */
	public String patId;
	/**
	 * 入院日期
	 */
	public String patInHospitalDate;
	/**
	 * 年龄
	 */
	public String patientAge;

	public SlidingLayer ris_result_view_sliding_layer;

	@Override
	public void setContentView() {
		setContentView(R.layout.fragment_ris);
	}

	@Override
	public void initView() {
		ris_result_view_sliding_layer = (SlidingLayer) findViewById(R.id.lis_result_view_sliding_layer);
		ris_result_view_sliding_layer.setShadowWidthRes(R.dimen.shadow_width);
		ris_result_view_sliding_layer
				.setShadowDrawable(R.drawable.sidebar_shadow);
		LayoutParams rlp = (LayoutParams) ris_result_view_sliding_layer
				.getLayoutParams();
		rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		ris_result_view_sliding_layer.setLayoutParams(rlp);

		risInformation = (ListView) findViewById(R.id.listView_ris_information);
		risInformationLayout = (LinearLayout) findViewById(R.id.ris_information_layout);
		risInforUnweb = (Button) findViewById(R.id.ris_infor_unweb);
		progressBarRisInformation = (ProgressBar) findViewById(R.id.progressBar_ris_information);

		risResult = (ListView) findViewById(R.id.listView_ris_result);
		risResultLayout = (LinearLayout) findViewById(R.id.ris_result_layout);
		risResultUnweb = (Button) findViewById(R.id.ris_result_unweb);
		progressBarRisResult = (ProgressBar) findViewById(R.id.progressBar_ris_result);

	}

	@Override
	public void initData() {
		progressBarRisInformation.setVisibility(View.VISIBLE);
		risInformation.setVisibility(View.GONE);
		risInforUnweb.setVisibility(View.GONE);
		RestClient.get(ReportApi.getRisByPatId(currentPatientBean.getId(),patId), null,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String content) {
						super.onSuccess(content);
						applyBeans = String2Model.string2RisApplyBean(content);
						risInfoAdapter = new RisInfoAdapter(RisActivity.this,
								applyBeans);
						risInformation.setAdapter(risInfoAdapter);
						progressBarRisInformation.setVisibility(View.GONE);
						risInformation.setVisibility(View.VISIBLE);
						risInforUnweb.setVisibility(View.GONE);
					}

					@Override
					public void onFailure(Throwable error, String content) {
						super.onFailure(error, content);
						progressBarRisInformation.setVisibility(View.GONE);
						risInformation.setVisibility(View.GONE);
						risInforUnweb.setVisibility(View.VISIBLE);
					}
				});
	}

	@Override
	public void initListener() {
		risInformation.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				CheckApplyBean checkApplyBean = applyBeans.get(arg2);
				risInfoAdapter.selectView(arg2);
				if (!ris_result_view_sliding_layer.isOpened()) {
					ris_result_view_sliding_layer.openLayer(true);
					getResultData(checkApplyBean);
				}
			}
		});

		risInforUnweb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				initData();
			}
		});
	}

	@Override
	public String setActionBarTitle() {
		return "检查   " + currentPatientBean.getBedNo().trim() + "床,"
				+ currentPatientBean.getName().trim();
	}

	@Override
	public void initIntent() {
		currentPatientBean = (PatientBean) getIntent().getParcelableExtra(
				"current_patient");
		if (currentPatientBean != null) {
			patId = StringUtils.getString(currentPatientBean.getPatId());
			patInHospitalDate = StringUtils.getString(currentPatientBean
					.getInHosDate());
			patientAge = StringUtils.getString(currentPatientBean.getAge());
		}
	}

	private void getResultData(CheckApplyBean checkApplyBean) {
		risResult.setVisibility(View.GONE);
		risResultUnweb.setVisibility(View.GONE);
		progressBarRisResult.setVisibility(View.VISIBLE);
//		RestClient.get(PublicApi.getRisResult(
//				StringUtils.getString(checkApplyBean.getPatId()),
//				StringUtils.getString(checkApplyBean.getId()),
//				StringUtils.getString(checkApplyBean.getRequestDate()), ""),
//				null, new AsyncHttpResponseHandler() {
//					@Override
//					public void onSuccess(String content) {
//						super.onSuccess(content);
//						resultBeans = String2Model
//								.string2RisResultBean(content);
//						if (resultBeans.size() > 0) {
//							risResultAdapter = new RisResultAdapter(
//									RisActivity.this, resultBeans);
//							risResult.setAdapter(risResultAdapter);
//						}
//						risResult.setVisibility(View.VISIBLE);
//						risResultUnweb.setVisibility(View.GONE);
//						progressBarRisResult.setVisibility(View.GONE);
//					}
//
//					@Override
//					public void onFailure(Throwable error, String content) {
//						super.onFailure(error, content);
//						risResult.setVisibility(View.GONE);
//						risResultUnweb.setVisibility(View.VISIBLE);
//						progressBarRisResult.setVisibility(View.GONE);
//					}
//				});
	}

}
