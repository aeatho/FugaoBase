package com.fugao.view;

import java.util.Date;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.PopupWindow;

import com.fugao.R;
import com.fugao.utils.DateUtils;

public class PopMenuCalendar implements OnDateChangeListener, OnClickListener {
	public interface OnClickListener {
		public void onClick(String currentDate);
	}

	private Context context;
	private LayoutInflater inflater;
	private OnClickListener listener;
	// 弹出框
	private PopupWindow popupWindow;
	// 日历
	private CalendarView calendarView;
	// 确定
	private Button pop_date_certain;
	// 当前的日期
	private String currentDate;

	/**
	 * 
	 * @param context
	 *            当前时间 格式为 yyyy-MM-dd
	 * @param currentDate
	 */
	public PopMenuCalendar(Context context, String currentDate) {
		this.context = context;
		this.currentDate = currentDate;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.popmenu_calendar, null);

		calendarView = (CalendarView) view.findViewById(R.id.pop_date);
		pop_date_certain = (Button) view.findViewById(R.id.pop_date_certain);
		calendarView.setOnDateChangeListener(this);
		pop_date_certain.setOnClickListener(this);

		popupWindow = new PopupWindow(view, context.getResources()
				.getDimensionPixelSize(R.dimen.popmenu_calender_width), // 这里宽度需要自己指定，使用
				// WRAP_CONTENT
				// 会很大
				context.getResources().getDimensionPixelSize(
						R.dimen.popmenu_calender_height));
		// 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景（很神奇的）
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		initData();
	}

	private void initData() {
		Date date = DateUtils.getDateTimeByString(currentDate);
		if (date == null) {
			date = new Date();
		}
		currentDate = DateUtils.toTime(date, "yyyy-MM-dd");
		calendarView.setDate(date.getTime());
	}

	public void showAsDropDown(View parent, int xoff, int yoff) {
		popupWindow.showAsDropDown(parent, xoff, yoff);
		// 使其聚集
		popupWindow.setFocusable(true);
		// 设置允许在外点击消失
		popupWindow.setOutsideTouchable(true);
		// 刷新状态
		popupWindow.update();
	}

	// 设置菜单项点击监听器
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	// 隐藏菜单
	public void dismiss() {
		popupWindow.dismiss();
	}

	@Override
	public void onClick(View arg0) {
		if (listener != null) {
			listener.onClick(currentDate);
		}
		dismiss();
	}

	@Override
	public void onSelectedDayChange(CalendarView view, int year, int month,
			int dayOfMonth) {
		String mm = (month + 1) + "";
		if (month + 1 < 10) {
			mm = "0" + mm;
		}
		String dd = dayOfMonth + "";
		if (dayOfMonth < 10) {
			dd = "0" + dd;
		}
		currentDate = year + "-" + mm + "-" + dd;
	}
}
