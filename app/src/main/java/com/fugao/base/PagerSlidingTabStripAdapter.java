package com.fugao.base;
import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

public class PagerSlidingTabStripAdapter extends FragmentPagerAdapter {

	private String[] TITLES;
	private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
	public PagerSlidingTabStripAdapter(FragmentManager fm,
			ArrayList<Fragment> fragments, String[] TITLES) {
		super(fm);
		this.fragments = fragments;
		this.TITLES = TITLES;
		this.fragmentManager=fm;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TITLES[position];
	}
	@Override  
	public int getItemPosition(Object object) {  
	    return POSITION_NONE;  
	}  
	public void setFragments(ArrayList<Fragment> fragments1,String[] TITLES) {
		if (this.fragments != null) {
			FragmentTransaction ft = fragmentManager.beginTransaction();
			for (Fragment f : this.fragments) {
				ft.remove(f);
			}
			ft.commit();
			ft = null;
			fragmentManager.executePendingTransactions();
		}
		this.fragments = fragments1;
		this.TITLES=TITLES;
		notifyDataSetChanged();
	}
	
	public void setFragments(ArrayList<Fragment> fragments) {
		if (this.fragments != null) {
			FragmentTransaction ft = fragmentManager.beginTransaction();
			for (Fragment f : this.fragments) {
				ft.remove(f);
			}
			ft.commit();
			ft = null;
			fragmentManager.executePendingTransactions();
		}
		this.fragments = fragments;
		notifyDataSetChanged();
	}
}
