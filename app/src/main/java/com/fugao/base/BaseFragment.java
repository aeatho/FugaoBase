package com.fugao.base;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 碎片基类
 * @author findchen
 * TODO
 * 2013-6-18下午1:20:00
 */
public abstract class BaseFragment extends Fragment {
	/**
	 * 当前activity
	 */
	public Activity fatherActivity;
	/**
	 * 当前视图
	 */
	public View currentView;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.fatherActivity = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 currentView = setContentView(inflater, container,
				savedInstanceState);
	
		initView(currentView);
		initData();
		initListener();
		return currentView;
	}

	public abstract View setContentView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState);
	public abstract void initView(View currentView);
	public abstract void initData();
	public abstract void initListener();

}
