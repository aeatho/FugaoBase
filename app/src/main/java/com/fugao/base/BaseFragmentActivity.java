package com.fugao.base;

import com.fugao.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.WindowManager;

/**
 * 有actionbar 的 普通类类
 * 
 * @author findchen TODO 2013-6-18下午1:43:31
 */
public abstract class BaseFragmentActivity extends FragmentActivity {
	/*
	 * 1 遇到的问题 ： getActionBar() 报错 : 解决方法： 在androidmainfest中
	 * 修改支持的最低版本为android:minSdkVersion="11"
	 */
	public ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView();
		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.nav_bg));
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setTitle(setActionBarTitle());

		initView();
		initData();
		initListener();

	}

	/**
	 * 实现 setContentView(R.layout.xx)
	 */
	public abstract void setContentView();

	/**
	 * 初始组件
	 */
	public abstract void initView();

	public abstract void initData();

	public abstract String setActionBarTitle();

	public abstract void initListener();

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
