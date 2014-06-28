package com.fugao.utils;

import com.fugao.R;
import com.fugao.model.PatientBean;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * 病人信息的判断
 * 
 * @ClassName: PatientBeanUtils
 * @Description: TODO
 * @author: 陈亮 chenliang@fugao.com
 * @date: 2014年5月22日 下午8:01:25
 */
public class PatientBeanUtils {
	/**
	 * 男
	 */
	public static int MAN = 1;
	/**
	 * 女
	 */
	public static int WOMAN = 2;

	/**
	 * 得到护理等级的图片
	 * 
	 * @Title: getNurseCareBg
	 * @Description: TODO
	 * @param context
	 * @param patientBean
	 * @return
	 * @return: Drawable
	 */
	public static Drawable getNurseCareBg(Context context,
			PatientBean patientBean) {
		Drawable drawable = null;
		String carName = StringUtils.getString(patientBean.getCareName());
		String carCode = StringUtils.getString(patientBean.getCareLevel());
		String cstCareLevel = StringUtils.getString(patientBean
				.getCstCareLevel());
		if (carName.contains("特级") || carCode.equals("0")
				|| cstCareLevel.equals("0")) {
			// 护理名称
			drawable = context.getResources().getDrawable(
					R.drawable.nurse_grade_special);
		} else if (carName.contains("一级") || carCode.equals("1")
				|| cstCareLevel.equals("1")) {
			drawable = context.getResources().getDrawable(
					R.drawable.nurse_grade_one);
		} else if (carName.contains("二级") || carCode.equals("2")
				|| cstCareLevel.equals("2")) {
			drawable = context.getResources().getDrawable(
					R.drawable.nurse_grade_two);
		} else if (carName.contains("三级") || carCode.equals("3")
				|| cstCareLevel.equals("3")) {
			drawable = context.getResources().getDrawable(
					R.drawable.nurse_grade_three);
		}
		return drawable;
	}

	/**
	 * 得到过敏信息的图片
	 * 
	 * @Title: getNurseAllery
	 * @Description: TODO
	 * @param context
	 * @param patientBean
	 * @return
	 * @return: Drawable
	 */
	public static Drawable getNurseAllery(Context context,
			PatientBean patientBean) {
		Drawable drawable = null;
		String alleryValue = StringUtils
				.getString(patientBean.getDrugAllergy());
		if (alleryValue.contains(" ")) {
			//
			// drawable=context.getResources().getDrawable(
			// R.drawable.nurse_allergy);
		}
		return drawable;
	}

	/**
	 * 
	 * @Title: getSexName
	 * @Description: TODO
	 * @param patientBean
	 * @param hospital
	 * @param context
	 * @return
	 * @return: String
	 */
	public static String getSexName(PatientBean patientBean, String hospital,
			Context context) {
		String sexName = "";
		String sexCode = StringUtils.getString(patientBean.getSex());
		if (hospital.contains("simc")) {
			if ("1".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_man);
			} else if ("2".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_woman);
			} else {
				sexName = "性别错误+code=" + sexCode;
			}
		} else if (hospital.contains("hzx")) {
			if ("1".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_man);
			} else if ("2".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_woman);
			} else {
				sexName = "性别错误+code=" + sexCode;
			}
		} else if (hospital.contains("ek")) {
			if ("1".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_man);
			} else if ("2".equals(sexCode)) {
				sexName = ResourceUtils.getResouceString(context,
						R.string.sex_woman);
			} else {
				sexName = "性别错误+code=" + sexCode;
			}
		} else {
			sexName = "请配置当前医院";
		}
		return sexName;
	}

	/**
	 * 显示病人列表的 头像数据
	 * 
	 * @Title: getShowPatientIcon
	 * @Description: TODO
	 * @param patientBean
	 * @param hospital
	 * @param context
	 * @return
	 * @return: Drawable
	 */
	public static Drawable getShowPatientIcon(PatientBean patientBean,
			String hospital, Context context) {
		Drawable drawable = null;
		String sexCode = StringUtils.getString(patientBean.getSex());
		if (hospital.contains("simc")) {
			if ("1".equals(sexCode)) {
				drawable = getSexDrawable(MAN, patientBean, context);
			} else if ("2".equals(sexCode)) {
				drawable = getSexDrawable(WOMAN, patientBean, context);
			}
		} else if (hospital.contains("hzx")) {
			if ("1".equals(sexCode)) {
				drawable = getSexDrawable(MAN, patientBean, context);
			} else if ("2".equals(sexCode)) {
				drawable = getSexDrawable(WOMAN, patientBean, context);
			}
		} else if (hospital.contains("ek")) {
			if ("1".equals(sexCode)) {
				drawable = getSexDrawable(MAN, patientBean, context);
			} else if ("2".equals(sexCode)) {
				drawable = getSexDrawable(WOMAN, patientBean, context);
			}
		}
		return drawable;

	}

	/**
	 * 显示图片 按照 入院和出院的 状态显示
	 * 
	 * @Title: getSexDrawable
	 * @Description: TODO
	 * @param sexPublicCode
	 * @param patientBean
	 * @param context
	 * @return
	 * @return: Drawable
	 */
	private  static Drawable getSexDrawable(int sexPublicCode,
			PatientBean patientBean, Context context) {
		Drawable drawable = null;
		if (sexPublicCode == MAN) {
			if (patientBean.getOutHosDate() != null) {
				if (("-1").equals(StringUtils.getString(patientBean
						.getOutHosDate()))) {
					drawable = context.getResources().getDrawable(
							R.drawable.boynow);
				} else {
					drawable = context.getResources().getDrawable(
							R.drawable.boyold);
				}
			} else {
				drawable = context.getResources()
						.getDrawable(R.drawable.boynow);
			}
		} else if (sexPublicCode == WOMAN) {
			if (patientBean.getOutHosDate() != null) {
				if (("-1").equals(StringUtils.getString(patientBean
						.getOutHosDate()))) {
					drawable = context.getResources().getDrawable(
							R.drawable.girlnow);
				} else {
					drawable = context.getResources().getDrawable(
							R.drawable.girlold);
				}
			} else {
				drawable = context.getResources().getDrawable(
						R.drawable.girlnow);
			}
		}
		return drawable;
	}
}
