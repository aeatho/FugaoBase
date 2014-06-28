package com.fugao.constant;

import com.fugao.utils.DateUtils;
import com.fugao.utils.StringUtils;

/**
 * 查房特殊接口
 * 
 * @author findchen TODO 2013-6-8上午9:17:03
 */
public class SearchApi extends PublicApi {
	public static String GET_WELCOME_URL = "/Home/ShowMe";
	public static String GET_MEDICAL = BASE_URL + "restMedical/?";

	// 护理
	public static String GET_NURSE_URL = "Plugin/Cis/ViewTemperatureByPatId";
	public static String GET_NURSE_TEMP = BASE_URL + "RestNurseTemp/";

	// 产科
	public static String CASE_RECORD = BASE_URL + "RestCasehistoryRecord";

	/**
	 * 危机值
	 */
	public static String GET_REMINDDATA = BASE_URL + "RestInfos?";
	public static String GET_FULLRANG = BASE_URL + "ohh?";

	/**
	 * 获取患者 体温单 的范围 $filter=PatId eq '176297' and DocType eq '0'&$orderby=Id
	 * desc
	 * api/RestNurseTemp/?patId=233203&inhosDate=20120929&outhosDate=20121122
	 * 
	 * @param patId
	 *            住院号
	 * @return
	 */
	public static String getRestNurseTemp(String patId, String inhosDate,
			String outhosDate) {
		String resultString = "";
		String subParams = "?patId=" + patId + "&inhosDate=" + inhosDate
				+ "&outhosDate=" + outhosDate;
		resultString = GET_NURSE_TEMP + subParams;
		return resultString;
	}

	/**
	 * 根据患者的门诊号，和开始日期得到体温单图片的地址
	 * Plugin/Cis/ViewTemperatureByPatId?patId=169413&beginDate=20120920
	 * 
	 * @param url
	 *            体温单的相对URL
	 * @return 体温单的绝对URL
	 */
	public static String getViewNurseTempRecordUrl(String patId,
			String beginDate) {
		String resultString = "";
		resultString = GET_NURSE_URL + "?patId=" + patId + "&beginDate="
				+ beginDate;
		return resultString;
	}

	// TODO 病历模块

	/**
	 * 根据住院号 获取该患者 的文档类型数
	 * 
	 * @param patid
	 *            病人的ID
	 * @return
	 */
	public static String getRecordCategoryByPatid(String patid) {
		String resultString = "";
		String subParams = "patid={0}";
		subParams = subParams.replace("{0}", patid);
		resultString = GET_MEDICAL + subParams;
		return resultString;
	}

	public static String GET_VIEW_MEDIA_RECORDS = "efcis/medical/ViewMedicalRecords?";

	/**
	 * 根据病人的病历的类型 得到病历
	 * 
	 * @param patId
	 *            病人的ID
	 * @param Type
	 *            病历的类型
	 * @param start
	 *            开始
	 * @param max
	 *            最大的
	 * @return
	 */
	// /efcis/medical/ViewMedicalRecords?patId=169413&code=C&name=日常病程录&max=10
	public static String getViewMedicalRecords(String patId, String code,
			String name, int max) {
		String resultString = "";
		String subParams = "patId={0}&code={1}&name={2}&max={3}";

		subParams = subParams.replace("{0}", patId).replace("{1}", code)
				.replace("{2}", name).replace("{3}", max + "");
		resultString = GET_VIEW_MEDIA_RECORDS + subParams;
		return resultString;
	}

	/**
	 * web端病历系统的展示
	 * 
	 * @Title: getMedicalRecords
	 * @Description: TODO
	 * @param patId
	 *            病人号码
	 * @return
	 * @return: String
	 */
	public static String getMedicalRecords(String patId) {
		String resultString = "";
		resultString = GET_VIEW_MEDIA_RECORDS + "patId=" + patId;
		return resultString;
	}

	public static String GET_VIEW_MEDIA = "efcis/medical/ViewMedical?";

	/**
	 * 病例web接口
	 * 
	 * @param patId
	 * @return
	 */
	public static String getMedical(String patId, String date) {
		String resultString = "";
		resultString = GET_VIEW_MEDIA + "patId=" + patId + "&date=" + date;
		return resultString;
	}

	// TODO 医嘱模块

//	/**
//	 * 得到长期和临时，出院的医嘱 //
//	 * http://localhost:8000/api/RestAdvice/?patId=765267&type=0
//	 * &$inlinecount=allpages&$top=1&$skip=3&$orderby=Id,BeginDate,BeginTime
//	 * 
//	 * @param patId
//	 *            病人的ID
//	 * @param type
//	 *            0-长期，1-临时，2-出院
//	 * @param start
//	 *            第几页
//	 * @param max
//	 *            每页大小
//	 * @return
//	 */
//	public static String getALLAdvice(String patId, String type, int start,
//			int max) {
//		String resultString = "";
//		String begin = "patId=" + patId + "&type=" + type;
//		String dividePage = "$inlinecount=allpages&$top=" + max + "&$skip="
//				+ start * max;
//		String filter = "$orderby=Id,BeginDate,BeginTime";
//		resultString = REST_ADVICE + begin + "&" + dividePage + "&" + filter;
//		return resultString.replace(" ", "%20");
//	}

//	public static String getBaseFilteAdvice(String patId, String type) {
//		String resultString = "";
//		resultString = REST_ADVICE + "patId=" + patId + "&type=" + type;
//		return resultString;
//	}
//
//	/**
//	 * 得到所有执行中的医嘱(针对 长期医嘱来说) stopflag:0-->未停止,1-->停止; ExeFlag : !=1 未执行 2-执行中
//	 * 3-已执行
//	 * 
//	 * @param patId
//	 *            病人的Id
//	 * @param type
//	 *            医嘱的类型
//	 *            
//	 * @param advicefilter 儿科接口  0 为儿科的接口，默认为其他医院的
//	 * 
//	 * @return
//	 */
//	public static String getALLExecuteAdvice(String patId, String type,
//			String advicefilter) {
//		String resultString = "";
//		String filter = "";
//		if (!StringUtils.StringIsEmpty(advicefilter)
//				&& advicefilter.equals("0")) {
//			if (type.equals("0")) {
//				//长期执行中
//				filter = "2";
//			} else {
//				//临时已执行
//				filter = "3";
//			}
//			resultString = (getBaseFilteAdvice(patId, type) + "&adstatus=" + filter)
//					.replace(" ", "%20");
//			return resultString;
//		} else {
//			if (type.equals("0")) {
//				filter = "$filter=StopFlag eq '0' and ExeFlag ne 'L' and ExeFlag ne '0' "
//						+ "&$orderby=Id,BeginDate,BeginTime";
//			} else {
//				filter = "$filter=(StopFlag eq '0' and ExeFlag ne 'L' and ExeFlag ne '0') or (StopFlag eq '1' and ExeFlag ne 'L' and ExeFlag ne '0') "
//						+ "&$orderby=Id,BeginDate,BeginTime";
//			}
//			resultString = (getBaseFilteAdvice(patId, type) + "&" + filter)
//					.replace(" ", "%20");
//			return resultString;
//		}
//	}
//
//	/**
//	 * 得到所有执行中的医嘱(针对 长期医嘱来说) stopflag:0-->未停止,1-->停止; ExeFlag : !=1 未执行
//	 * 
//	 * @param patId
//	 *            病人的Id
//	 * @param type
//	 *            医嘱的类型
//	 * @return
//	 */
//	public static String getALLExecuteAdvice(String patId, String type) {
//		String resultString = "";
//		String filter = "";
//		if (type.equals("0")) {
//			filter = "$filter=StopFlag eq '0' and ExeFlag ne 'L' and ExeFlag ne '0' "
//					+ "&$orderby=Id,BeginDate,BeginTime";
//		} else {
//			filter = "$filter=(StopFlag eq '0' and ExeFlag ne 'L' and ExeFlag ne '0') or (StopFlag eq '1' and ExeFlag ne 'L' and ExeFlag ne '0') "
//					+ "&$orderby=Id,BeginDate,BeginTime";
//		}
//		resultString = (getBaseFilteAdvice(patId, type) + "&" + filter)
//				.replace(" ", "%20");
//		return resultString;
//	}
//
//	/**
//	 * 得到所有未执行的医嘱（针对所有的医嘱） stopflag:0-->未停止,1-->停止 ExeFlag : !=1 未执行,1-->执行
//	 * 
//	 * @param patId
//	 *            病人的Id
//	 * @param type
//	 *            医嘱的类型
//	 * @param advicefilter 儿科接口  0 为儿科的接口，默认为其他医院的
//	 *          
//	 * @return
//	 */
//	public static String getALLUnExecuteAdvice(String patId, String type,
//			String advicefilter) {
//		String resultString = "";
//		if (!StringUtils.StringIsEmpty(advicefilter)
//				&& advicefilter.equals("0")) {
//			resultString = (getBaseFilteAdvice(patId, type) + "&adstatus=" + "8")
//					.replace(" ", "%20");
//			return resultString;
//		} else {
//			String getALLUnExecuteAdviceFilter = "$filter=StopFlag eq '0' and ExeFlag eq 'L' or ExeFlag eq '0' "
//					+ "&$orderby=Id,BeginDate,BeginTime";
//			resultString = (getBaseFilteAdvice(patId, type) + "&" + getALLUnExecuteAdviceFilter)
//					.replace(" ", "%20");
//			return resultString;
//		}
//	}
//
//	/**
//	 * 得到所有未执行的医嘱（针对所有的医嘱） stopflag:0-->未停止,1-->停止 ExeFlag : !=1 未执行,1-->执行
//	 * 
//	 * @param patId
//	 *            病人的Id
//	 * @param type
//	 *            医嘱的类型
//	 * @return
//	 */
//	public static String getALLUnExecuteAdvice(String patId, String type) {
//
//		String resultString = "";
//		String getALLUnExecuteAdviceFilter = "$filter=StopFlag eq '0' and ExeFlag eq 'L' or ExeFlag eq '0' "
//				+ "&$orderby=Id,BeginDate,BeginTime";
//		resultString = (getBaseFilteAdvice(patId, type) + "&" + getALLUnExecuteAdviceFilter)
//				.replace(" ", "%20");
//		return resultString;
//	}

	/**
	 * 得到暂存的数据
	 * http://192.168.15.61:8000/api/RestAdvice?patId=10111-0&type=0&$filter
	 * =StopFlag eq '0' and ExeFlag eq 'L'&$orderby=BeginDate,BeginTime,Id
	 * 
	 * @Title: getTempSaveAdvice
	 * @Description: TODO
	 * @param patId
	 *            病人的Id
	 * @param type
	 *            医嘱的类型 0--长期 1--临时 2--出院带药
	 * @return
	 * @return: String
	 */
//	public static String getTempSaveAdvice(String patId, String type) {
//		String resultString = "";
//		String getTempSaveAdviceFilter = "$filter=StopFlag eq '0' and ExeFlag eq 'L'&$orderby=Id,BeginDate,BeginTime";
//		resultString = (getBaseFilteAdvice(patId, type) + "&" + getTempSaveAdviceFilter)
//				.replace(" ", "%20");
//		return resultString;
//	}



//	/**
//	 * 获取检查数据
//	 * api/PluginRis/?patIds=175218_175220_175224_17225&$filter=RequestDate ge
//	 * '2012-12-20'&$inlinecount=allpages&$skip=0&$top=10
//	 * 
//	 * @param patId
//	 * @param rquestdate
//	 *            2012-12-20
//	 * @param index
//	 *            1.过滤时间 <>1。全部
//	 * @return
//	 */
//	public static String getRisByTime(String patId, String rquestdate, int index) {
//
//		String lastdata = DateUtils.getlastdata(rquestdate);
//		String resultString = "";
//
//		String basefilter = "patIds=" + patId;
//		String filter = "";
//		String orderBy = "&$orderby=RequestDate desc,ItemCode";
//		if (index == 1) {
//			filter = "filter=RequestDate ge '" + rquestdate
//					+ "'and RequestDate lt '" + lastdata + "'";
//			resultString = GET_RIS + basefilter + "&$"
//					+ filter.replace(" ", "%20") + orderBy.replace(" ", "%20");
//		} else if (index == 0) {
//			resultString = GET_RIS + basefilter + orderBy.replace(" ", "%20");
//		}
//		return resultString;
//	}

//	/**
//	 * /plugin/Ris/RisView?patid={0}&startDate={1}&endDate={2}
//	 * 
//	 * @Title: getRisWebByTime
//	 * @Description: TODO
//	 * @param patId
//	 * @param requestDate
//	 * @param index
//	 * @return
//	 * @return: String
//	 */
//	public static String getRisWebByTime(String patId, String requestDate) {
//		String lastdate = DateUtils.getCurrentDate("yyyy-MM-dd");
//		String resultString = RIS_WEB + patId + "&startDate=" + requestDate
//				+ "&endDate=" + lastdate;
//		return resultString;
//	}

//	/**
//	 * 获取检验申请:按住院号和入院日期
//	 * 
//	 * api/PluginLis/?patIds=176077&inDate=20130118&$skip=0&$top=10&$inlinecount
//	 * =allpages
//	 * 
//	 * @param patId
//	 * @param start
//	 * @param max
//	 * @param beginTime
//	 * @param endTime
//	 * @return
//	 */
//	public static String getLisByTime(String patId, String inDate) {
//		String resultString = "";
//		String basefilter = "patIds=" + patId;
//		String orderBy = "&$orderby=RequestDate%20desc,Type";
//		resultString = GET_LIS + basefilter + "&inDate=" + inDate + orderBy;
//		return resultString;
//	}

	/**
	 * 获得记录浏览目录
	 * 
	 * @Title: getCaseRecordInfo
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public static String getCaseRecordCatalogs(String patId) {
		String resultString = "";
		resultString = CASE_RECORD + "?patid=" + patId;
		return resultString;
	}

	/**
	 * 获得记录浏览详情
	 * 
	 * @Title: getCaseRecordInfo
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	public static String getCaseRecordInfo(String patId, String type) {
		String resultString = "";
		resultString = CASE_RECORD + "?" + "PatIds=" + patId
				+ "&WatCode=all&RecordType=" + type + "&Statues=3";
		return resultString;
	}


	public static String saveCrisersHistory(String doctorId) {
		String resultString = "";
		resultString = GET_REMINDDATA + "doctorId=" + doctorId;
		return resultString;
	}

	public static String getFullRangeViewById(String patId) {
		String resultString = "";
		resultString = GET_FULLRANG + "patId=" + patId;
		return resultString;
	}
}
