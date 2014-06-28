package com.fugao.base;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fugao.R;
import com.fugao.view.PagerSlidingTabStrip;

/**
 * fragment 中包含 viewpager ,和slidingmenu 一起使用
 * 
 * @author findchen_2013 2013年11月23日上午11:39:52
 */
public abstract class BasePagerSlidingFragments extends Fragment implements
		OnPageChangeListener {
	public Activity fatherActivity;
	public View currentView;
	public LinearLayout head_layout_showLeft;
	public PagerSlidingTabStrip tabs;
	public ViewPager pager;

	public ArrayList<Fragment> fragments;
	public PagerSlidingTabStripAdapter adapter;
	public String[] mTitles;
	DisplayMetrics displayMetrics = new DisplayMetrics();
	public int phoneWidth;


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.fatherActivity = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fatherActivity.getWindowManager().getDefaultDisplay()
				.getMetrics(displayMetrics);
		phoneWidth = displayMetrics.widthPixels;
		currentView = inflater.inflate(R.layout.base_pager_sliding_fragments, null,
				false);
		return currentView;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		initBasicView();
		initView(currentView);
		initListener();
	}

	public void initBasicView() {
		tabs = (PagerSlidingTabStrip) currentView.findViewById(R.id.tabs);
		pager = (ViewPager) currentView.findViewById(R.id.pager);
		tabs.setOnPageChangeListener(this);
		initData();
		fragments = setFragments();

		mTitles = setTitleArray();
		adapter = new PagerSlidingTabStripAdapter(getChildFragmentManager(),
				fragments, mTitles);

		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		tabs.getTextSize();

		tabs.setIndicatorColor(getResources().getColor(
				R.color.detail_tabindictor));
		int tabChildSize = fragments.size();
		int titleCount = 0;
		String titleString = "";
		for (String string : mTitles) {
			titleString += string;
		}
		titleCount = titleString.length();
		if (titleCount <= 12) {
			int width = phoneWidth / tabChildSize;
			tabs.setTabWidth(width);
		}
	}

	public abstract void initView(View currentView);

	public abstract void initData();

	public abstract void initListener();

	public abstract ArrayList<Fragment> setFragments();
	/**
	 * 设置viewpager 的标题
	 * @return
	 */
	public abstract String[] setTitleArray();

	/**
	 * 刷新数据
	 * 
	 * @param view
	 */
	public abstract void refresh(View view);

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}


	public boolean isFirst() {
		if (pager.getCurrentItem() == 0)
			return true;
		else
			return false;
	}

	public boolean isEnd() {
		if (pager.getCurrentItem() == fragments.size() - 1)
			return true;
		else
			return false;
	}

}
