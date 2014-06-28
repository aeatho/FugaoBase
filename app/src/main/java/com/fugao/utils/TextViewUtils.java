package com.fugao.utils;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;


public class TextViewUtils {

	// String param = "abc" ;
	// String text = param + "dfdjkfjdkfjdfjdkf" ;
	//
	//
	// ss.setSpan(new StyleSpan(Typeface.BOLD),0, param.length(),
	// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	// ss.setSpan(new AbsoluteSizeSpan(30,true), 0, param.length(),
	// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	// ss.setSpan(new AbsoluteSizeSpan(16,true), param.length(), text.length(),
	// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	// textView.setText(ss);
	//

	// sb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD),
	// finalString.indexOf(normalBOLD), normalBOLD.length(),
	// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //bold
	// sb.setSpan(new AbsoluteSizeSpan(intSize),
	// finalString.indexOf(normalBOLD), normalBOLD.length(),
	// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//resize size
	//
	// public static setTextByLength(TextView textView,String string ){
	//
	// }

	public static void showHtml(TextView textView, String htmlString) {
		Spanned styledText = Html.fromHtml(htmlString);
		textView.setText(styledText);
	}

	public static void setMixTextSize(TextView view, String string, int start,
			int end, int textsize) {
		Spannable sp = new SpannableString(string);
		sp.setSpan(new AbsoluteSizeSpan(textsize), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		view.setText(sp);
	}

	public static void setMixTextSizeAndTextColor(TextView view, String string,
			int start, int end, int textsize, int color) {
		Spannable sp = new SpannableString(string);
		sp.setSpan(new AbsoluteSizeSpan(textsize), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		sp.setSpan(new ForegroundColorSpan(color), start, end,
				Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		view.setText(sp);
	}

	/**
	 * @param view
	 *            textview you want to truncate,
	 * @param maxLine
	 *            maxLines you want to display in textview you could not
	 *            setEllipse() or android:lines in xml just use this method to
	 *            truncate
	 */
	public static void truncate(final TextView view, final int maxLine) {
		ViewTreeObserver vto = view.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			public void onGlobalLayout() {
				if (view.getLineCount() > maxLine) {
					int lineEndIndex = view.getLayout().getLineEnd(maxLine - 1);
					String text = view.getText().subSequence(0,
							lineEndIndex - 3)
							+ "...";
					view.setText(text);
				}
			}
		});
	}
	public static void setStrikethroughAndBackground(TextView textView,
			String string, int color) {
		SpannableString span = new SpannableString(string);
		span.setSpan(new StrikethroughSpan(), 0, string.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		span.setSpan(new ForegroundColorSpan(color), 0, string.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		textView.setText(span);
	}
}
