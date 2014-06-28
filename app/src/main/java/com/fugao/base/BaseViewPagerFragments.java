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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fugao.R;
import com.fugao.view.PagerSlidingTabStrip;
import com.fugao.view.slidingmenu.SlidingMenu;
import com.fugao.view.slidingmenu.app.SlidingFragmentActivity;

/**
 * fragment 中包含 viewpager ,和slidingmenu 一起使用
 * getChildFragmentManager 在碎片中使用碎片 则需要获取 fragment 的事务控制，
 * 切记，不要忘记。by keng man.
 * 
 * @author findchen_2013 2013年11月23日上午11:39:52
 */
public abstract class BaseViewPagerFragments extends Fragment implements
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

	public ImageView iv_left_icon;
	public ImageView iv_right_icon;

	public TextView middleTextView;

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
		currentView = inflater.inflate(R.layout.base_viewpager_fragments, null,
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
		iv_left_icon = (ImageView) currentView.findViewById(R.id.iv_left_icon);
		iv_right_icon = (ImageView) currentView
				.findViewById(R.id.iv_right_icon);
		iv_left_icon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SlidingFragmentActivity mainActivity = (SlidingFragmentActivity) fatherActivity;
				mainActivity.toggle();
			}
		});
		iv_right_icon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh(v);
			}
		});
		middleTextView = (TextView) currentView
				.findViewById(R.id.base_view_pager_fragment_title);

		initTopBar(iv_left_icon, middleTextView, iv_right_icon);
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

	/**
	 * 初始化顶部的数据
	 * 
	 * @param leftView
	 * @param middleTextView
	 * @param rightImageView
	 */
	public abstract void initTopBar(ImageView leftView,
			TextView middleTextView, ImageView rightImageView);

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		SlidingFragmentActivity mainActivity = (SlidingFragmentActivity) fatherActivity;
		SlidingMenu slidingMenu = mainActivity.getSlidingMenu();
		if (isFirst()) {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		} else {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		}
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
