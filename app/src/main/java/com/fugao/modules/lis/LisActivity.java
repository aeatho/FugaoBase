package com.fugao.modules.lis;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.fugao.R;
import com.fugao.base.BaseTempleActivity;
import com.fugao.constant.PublicApi;
import com.fugao.constant.ReportApi;
import com.fugao.model.InspectApplyBean;
import com.fugao.model.InspectResultBean;
import com.fugao.model.PatientBean;
import com.fugao.utils.RestClient;
import com.fugao.utils.String2Model;
import com.fugao.utils.StringUtils;
import com.fugao.view.SlidingLayer;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * 检验 列表结果页面
 * 
 * @author gelp
 */
public class LisActivity extends BaseTempleActivity {
	/**
	 * 刷新
	 */
	private Button buttonRefresh;
	/**
	 * 检验申请列表
	 */
	private ListView ListviewLis;
	/**
	 * 检验申请列表
	 */
	private LisItemAdapter lisInformationAdapter;
	/**
	 * 主界面进度条
	 */
	private ProgressBar progressBarlisInfor;
	/**
	 * 进度条界面布局
	 */
	private LinearLayout progressLisInforLayout;
	/**
	 * 检验申请数据集合
	 */
	private ArrayList<InspectApplyBean> applyBeans;

	/**
	 * 检验结果列表
	 */
	private ListView lisListView;
	/**
	 * 检验结果进度条
	 */
	private ProgressBar progressBarLisResult;

	/**
	 * 网络重新访问
	 */
	private Button lisResultUnweb;
	/**
	 * 检验结果数据集合
	 */
	private ArrayList<InspectResultBean> resultBeans;
	/**
	 * 检验结果适配器
	 */
	private LisResultAdapter lisResultAdapter;
	/**
	 * 当前检查申请
	 */
	private InspectApplyBean inspectApplyBean;

	public SlidingLayer lis_result_view_sliding_layer;

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
	
	public ImageView lis_close_image_view;

	@Override
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.fragment_lis);
	}

	@Override
	public void initView() {
		progressBarlisInfor = (ProgressBar) findViewById(R.id.progressBar_lis_information);
		ListviewLis = (ListView) findViewById(R.id.listView_lis_information);
		buttonRefresh = (Button) findViewById(R.id.button_restart);
		progressLisInforLayout = (LinearLayout) findViewById(R.id.progress_lis_infor_layout);

		lis_result_view_sliding_layer = (SlidingLayer) findViewById(R.id.lis_result_view_sliding_layer);
		lis_result_view_sliding_layer.setShadowWidthRes(R.dimen.shadow_width);
		lis_result_view_sliding_layer.setShadowDrawable(R.drawable.sidebar_shadow);
		LayoutParams rlp = (LayoutParams) lis_result_view_sliding_layer
				.getLayoutParams();
		rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lis_result_view_sliding_layer.setLayoutParams(rlp);

		lisListView = (ListView) findViewById(R.id.listView_lis_result);
		lisResultUnweb = (Button) findViewById(R.id.lis_result_unweb);
		progressBarLisResult = (ProgressBar) findViewById(R.id.progressBar_lis_result);
		lis_close_image_view=(ImageView) findViewById(R.id.lis_close_image_view);
	
	}
	
	

	@Override
	public void initData() {
		ListviewLis.setVisibility(View.GONE);
		progressLisInforLayout.setVisibility(View.VISIBLE);
		progressBarlisInfor.setVisibility(View.VISIBLE);
		/**
		 * 请求获取检验父类数据
		 */
		RestClient.get(ReportApi.getLisByPatId(patId, patInHospitalDate), null,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String content) {
						super.onSuccess(content);
						applyBeans = String2Model.string2ApplyBean(content);
						lisInformationAdapter = new LisItemAdapter(
								LisActivity.this, applyBeans);
						ListviewLis.setAdapter(lisInformationAdapter);
						ListviewLis.setVisibility(View.VISIBLE);
						progressLisInforLayout.setVisibility(View.GONE);
					}

					@Override
					public void onFailure(Throwable error) {
						super.onFailure(error);
						buttonRefresh.setVisibility(View.VISIBLE);
						progressBarlisInfor.setVisibility(View.GONE);
					}
				});
	}

	@Override
	public String setActionBarTitle() {
		// TODO Auto-generated method stub
		return "检验   " + currentPatientBean.getBedNo().trim() + "床,"
				+ currentPatientBean.getName().trim();
	}

	@Override
	public void initListener() {
		ListviewLis.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				InspectApplyBean inspectApplyBean = applyBeans.get(arg2);
				lisInformationAdapter.selectView(arg2);
				if (!lis_result_view_sliding_layer.isOpened()) {
					lis_result_view_sliding_layer.openLayer(true);
					getResultData(inspectApplyBean);
				}

			}
		});

		buttonRefresh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				initData();
			}
		});
		lis_close_image_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (lis_result_view_sliding_layer.isOpened()) {
					lis_result_view_sliding_layer.closeLayer(true);
				}
			}
		});
	}

	/**
	 * 请求检验结果
	 * 
	 * @param applyBean
	 * @param position
	 */
	private void getResultData(InspectApplyBean applyBean) {
		lisListView.setVisibility(View.GONE);
		progressBarLisResult.setVisibility(View.VISIBLE);
		lisResultUnweb.setVisibility(View.GONE);
		RestClient.get(ReportApi.getLisResultByReportId(applyBean.getId(),
				applyBean.getRequestDate().substring(0, 10)), null,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String content) {
						super.onSuccess(content);
						resultBeans = String2Model
								.string2InspectResult(content);
						lisResultAdapter = new LisResultAdapter(
								LisActivity.this, resultBeans);
						lisListView.setAdapter(lisResultAdapter);

						lisListView.setVisibility(View.VISIBLE);
						progressBarLisResult.setVisibility(View.GONE);
						lisResultUnweb.setVisibility(View.GONE);
					}

					@Override
					public void onFailure(Throwable error, String content) {
						// TODO Auto-generated method stub
						super.onFailure(error, content);
						lisListView.setVisibility(View.GONE);
						progressBarLisResult.setVisibility(View.GONE);
						lisResultUnweb.setVisibility(View.VISIBLE);
					}

				});
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

}
