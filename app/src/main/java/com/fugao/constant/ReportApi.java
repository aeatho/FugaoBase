package com.fugao.constant;

import com.fugao.utils.DateUtils;

/**
 * 报告获取接口 检查和检验
 * @author chenliang
 *
 */
public class ReportApi extends PublicApi{
	/**
	 *  检查
	 */
	public static String GET_RIS = BASE_URL + "PluginRis/?";
	/**
	 *  检验
	 */
	public static String GET_LIS = BASE_URL + "PluginLis/?";	
	/**
	 * 检查 web界面
	 */
	public static String RIS_WEB = "plugin/Ris/RisView?patid=";
	
	/**
	 * 心电图 web页面
	 */
	public static String ECG_VIEW = "plugin/Ecg/EcgView?patid=";

	
	/**
	 * 获取一个病人的检查数据 
	 * @param id      序列号   fg5要求 低于fg5
	 * @param patId   住院号   
	 * @return
	 */
	public static String getRisByPatId(String id, String patId) {
		String resultString = "";
		resultString = GET_RIS +"id="+id+"&patId="+patId;
		return resultString;
	}
	
	/**
	 * 得到 检查的web 页面
	 * 
	 * @Title: getRisWEbURl
	 * @Description: TODO
	 * @param patId
	 *            住院号
	 * @return
	 * @return: String
	 */
	public static String getRisWEBURl(String patId) {
		String resultString = "";
		resultString = RIS_WEB + patId;
		return resultString;
	}
	
	/***
	 * 获得影像URL
	 * 
	 * @param idNum
	 *            检查报告号
	 * @return
	 */
	public static String getRisUrl(String idNum) {
		String resultString = "";
		resultString = GET_RIS + "idNum=" + idNum;
		return resultString;
	}
	/**
	 * 获取一条的检查的结果
	 * 
	 * @param patId
	 *            住院号
	 * @param reportId
	 *            报告号
	 * @param reportDate
	 *            请求日期
	 * @return
	 */
	public static String getRisResult(String patId, String reportId,
			String reportDate) {

		return GET_RIS + "patId=" + patId + "&reportId=" + reportId
				+ "&reportDate=" + reportDate.replace(" ", "%20");

	}
	/**
	 * 得到检验的结果
	 * 
	 * @param reportId
	 *            报告Id
	 * @param requestDate
	 *            申请日期
	 * @return
	 */
	public static String getLisResultByReportId(String reportId,
			String requestDate) {
		return GET_LIS + "reportId=" + reportId + "&dateTest=" + requestDate;
	}
	/***
	 * 根据病区得到检验申请的列表
	 * 
	 * @param divCode
	 * @param rquestdate
	 * @param start
	 * @param max
	 * @return
	 */
	public static String getLisDivCodeByTime(String divCode, String rquestdate) {
		String resultString = "";
		String basefilter = "divCode=" + divCode + "&dateTest=" + rquestdate;
		String orderBy = "&$orderby=Type,BedNo";
		resultString = GET_LIS + basefilter + orderBy.replace(" ", "%20");
		return resultString;
	}
	

	/**
	 * 得到心电图的地址
	 * 
	 * @Title: getECGWebURL
	 * @Description: TODO
	 * @param patId
	 *            住院号
	 * @return
	 * @return: String
	 */
	public static String getECGWEBURL(String patId) {
		String resultString = "";
		resultString = ECG_VIEW + patId;
		return resultString;
	}
	
	/**
	 * 根据患者 的门诊号和病人的入院日期得到患者的检验列表
	 * 
	 * @param patId
	 *            门诊号
	 * @param inDate
	 *            入院日期
	 * @return
	 */
	public static String getLisByPatId(String patId, String inDate) {

		String resultString = "";
		String basefilter = "patIds=" + patId;
		String orderBy = "&$orderby=RequestDate%20desc,Type";
		resultString = GET_LIS + basefilter + "&inDate=" + inDate + orderBy;
		return resultString;
	}
	
	/**
	 * 获取检验申请:按住院号和入院日期
	 * 
	 * api/PluginLis/?patIds=176077&inDate=20130118&$skip=0&$top=10&$inlinecount
	 * =allpages
	 * 
	 * @param patId
	 * @param start
	 * @param max
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static String getLisByTime(String patId, String inDate) {
		String resultString = "";
		String basefilter = "patIds=" + patId;
		String orderBy = "&$orderby=RequestDate%20desc,Type";
		resultString = GET_LIS + basefilter + "&inDate=" + inDate + orderBy;
		return resultString;
	}
	
	/**
	 * /plugin/Ris/RisView?patid={0}&startDate={1}&endDate={2}
	 * 
	 * @Title: getRisWebByTime
	 * @Description: TODO
	 * @param patId
	 * @param requestDate
	 * @param index
	 * @return
	 * @return: String
	 */
	public static String getRisWebByTime(String patId, String requestDate) {
		String lastdate = DateUtils.getCurrentDate("yyyy-MM-dd");
		String resultString = RIS_WEB + patId + "&startDate=" + requestDate
				+ "&endDate=" + lastdate;
		return resultString;
	}
	
	
	/**
	 * 获取检查数据
	 * api/PluginRis/?patIds=175218_175220_175224_17225&$filter=RequestDate ge
	 * '2012-12-20'&$inlinecount=allpages&$skip=0&$top=10
	 * 
	 * @param patId
	 * @param rquestdate
	 *            2012-12-20
	 * @param index
	 *            1.过滤时间 <>1。全部
	 * @return
	 */
	public static String getRisByTime(String patId, String rquestdate, int index) {

		String lastdata = DateUtils.getlastdata(rquestdate);
		String resultString = "";

		String basefilter = "patIds=" + patId;
		String filter = "";
		String orderBy = "&$orderby=RequestDate desc,ItemCode";
		if (index == 1) {
			filter = "filter=RequestDate ge '" + rquestdate
					+ "'and RequestDate lt '" + lastdata + "'";
			resultString = GET_RIS + basefilter + "&$"
					+ filter.replace(" ", "%20") + orderBy.replace(" ", "%20");
		} else if (index == 0) {
			resultString = GET_RIS + basefilter + orderBy.replace(" ", "%20");
		}
		return resultString;
	}

}
