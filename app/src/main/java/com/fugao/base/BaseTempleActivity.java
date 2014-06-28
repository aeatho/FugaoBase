package com.fugao.base;
import com.fugao.R;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.WindowManager;
/**
 * activity 模版类
 * @author findchen_2013
 * 2013年11月5日下午2:39:26
 */
public abstract class BaseTempleActivity extends FragmentActivity {
	public ActionBar actionBar;
	DisplayMetrics displayMetrics = new DisplayMetrics();
	public int windowWidth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		getWindowManager().getDefaultDisplay()
		.getMetrics(displayMetrics);
		windowWidth = displayMetrics.widthPixels;
		setContentView();
		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.nav_bg));
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		initIntent();
		actionBar.setTitle(setActionBarTitle());
		initView();
		initData();
		initListener();

	}

	
	public abstract void setContentView();

	
	public abstract void initView();

	public abstract void initData();

	public abstract String setActionBarTitle();
	
	public abstract void initListener();
	
	public abstract void initIntent();
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
