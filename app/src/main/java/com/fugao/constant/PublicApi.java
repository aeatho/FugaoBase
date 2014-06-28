package com.fugao.constant;

import java.net.URLEncoder;


/**
 * 所以程序的公用接口
 * 
 * @author chenliang
 * @date 2013-3-14
 */
public abstract class PublicApi {

	public static String API_NAME = "api";
	// 公用的地址
	public static String BASE_URL = API_NAME + "/";

	/********************************************************/
	/**
	 * 登录的基本URL
	 */
	public static String LOGIN_URL = BASE_URL + "restaccount/?";
	/**
	 * 病区相关基本接口
	 */
	public static String GET_DEPT = BASE_URL + "RestDept/?";
	/**
	 * 病人相关基本接口
	 */
	public static String GET_PATIENT = BASE_URL + "RestPatient/?";

	/**
	 * 得到长期和临时，出院的医嘱 基本地址 例如： /api/RestAdvice/?
	 */
	public static String REST_ADVICE = BASE_URL + "RestAdvice/?";

	/**
	 * 体温接口
	 */
	private static String GET_TEMP = BASE_URL + "RestTemperatureChart?";
	/**
	 * 便签的基本地址
	 */
	public static String TASK_BASE = BASE_URL + "resttodo?";
	/**
	 * 便签文件基本地址
	 */
	public static String NOTES_BASE = TASK_BASE + "$expand";
	/**
	 * 得到所有文件的基本的路径,文件操作 上传的url 例如 ：api/RestFile/?
	 */
	public static String FILE_BASE = BASE_URL + "RestFile/?";
	/**
	 * 文件访问路径
	 */
	public static String ATTACH_HTTP = BASE_URL + "Uploading/?";

	public static String MESSAGE_CENTER = BASE_URL + "RestMessageCenter?";

	public static String ACTION_RECORD = BASE_URL + "ActionRecord";

	// http://192.168.15.25:8000/api/restaccount/?username=0000&userpwd=1&remember=0&os=android&versioncode=1&appsName=mobile_nurse
	/**
	 * 登录(不包含科室病区)
	 * 
	 * @param usenameValue
	 * @param passwordValue
	 * @param isRember
	 * @param versioncode
	 * @param appsName
	 * @return
	 */
	public static String login(String usenameValue, String passwordValue,
			boolean isRember, int versioncode, String appsName) {
		String resultString = LOGIN_URL + "username=" + usenameValue
				+ "&userpwd=" + passwordValue
				+ "&remember=0&os=android&versioncode=" + versioncode
				+ "&appsName=" + appsName;
		return resultString;
	}

	/**
	 * 登录  服务器端不返回cookie给客户端
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param usenameValue
	 * @param passwordValue
	 * @return
	 * @return: String
	 */
	public static String login(String usenameValue, String passwordValue) {
		String resultString = LOGIN_URL + "username=" + usenameValue
				+ "&userpwd=" + passwordValue;
		return resultString;
	}

	/**
	 * 登录(包含科室病区)
	 * 
	 * @Title: login2
	 * @Description: TODO
	 * @param usenameValue
	 * @param passwordValue
	 * @param isRember
	 * @param versioncode
	 * @param appsName
	 * @return
	 * @return: String
	 */
	public static String login2(String usenameValue, String passwordValue,
			boolean isRember, int versioncode, String appsName) {
		String resultString = LOGIN_URL + "username=" + usenameValue
				+ "&userpwd=" + passwordValue
				+ "&remember=0&os=android&versioncode=" + versioncode
				+ "&appsName=" + appsName + "&paramaters=" + appsName;
		return resultString;
	}

	@Deprecated
	public static String login(String usenameValue, String passwordValue,
			boolean isRember, String appName) {
		String resultString = LOGIN_URL + "username=" + usenameValue
				+ "&userpwd=" + passwordValue + "&remember=0&sysKey=" + appName;
		return resultString;
	}

	/**
	 * 根据当前用户的权限，获取 所在病区及所在科室。
	 * 
	 * @return
	 */
	public static String getDivisionsByRole() {
		String resultString = "";
		resultString = GET_DEPT;
		return resultString;
	}

	/**
	 * 得到所有病区科室
	 * 
	 * @param divisonCode
	 *            key 病区号
	 * @return
	 */
	public static String getDivisionsByCode(String divisonCode) {
		String resultString = "";
		resultString = (GET_DEPT + "key=" + divisonCode).replace(" ", "%20");
		return resultString;
	}

	/**
	 * 得到所有的病区
	 * 
	 * @return
	 */
	public static String getAllDivisions() {
		String resultString = "";
		resultString = (GET_DEPT + "key=all").replace(" ", "%20");
		return resultString;
	}

	/**
	 * 得到病区的所有病人列表
	 * 
	 * @param division
	 *            病区,
	 * @param dept
	 *            部门编号
	 * @return
	 */
	public static String getAllPatient(String division, String dept) {
		String resultString = "";
		String begin = "division=" + division + "&dept=" + dept;
		resultString = (GET_PATIENT + begin).replace(" ", "%20");
		return resultString;
	}
	/**
	 * 获取病人的所有信息
	 * @Title: getALLPatientInfo 
	 * @Description: TODO
	 * @param division
	 * @return
	 * @return: String
	 */
	public static String getALLPatientInfo(String division){
		String resultString = "";
		String begin = "division=" + division + "&otherInfo=all";
		resultString = (GET_PATIENT + begin).replace(" ", "%20");
		return resultString;
	}

	/**
	 * 得到病区的所有病人列表
	 * 
	 * @param division
	 *            病区
	 * @return
	 */
	public static String getAllPatient(String division) {
		String resultString = "";
		String begin = "division=" + division;

		resultString = (GET_PATIENT + begin).replace(" ", "%20");

		return resultString;
	}

	/**
	 * 根据住院号或者姓名查询患者
	 * 
	 * @param key
	 *            住院号或姓名 如:(api/RestDept/?key=176491)(api/RestDept/?key=朱恩彦)
	 * @return
	 */
	public static String getPatient(String key) {
		String resultString = "";

		resultString = (GET_PATIENT + "key=" + key).replace(" ", "%20");

		return resultString;
	}

	// /**
	// * 根据患者 的门诊号和病人的入院日期得到患者的检验列表
	// *
	// * @param patId
	// * 门诊号
	// * @param inDate
	// * 入院日期
	// * @return
	// */
	// public static String getLisByPatId(String patId, String inDate) {
	//
	// String resultString = "";
	// String basefilter = "patIds=" + patId;
	// String orderBy = "&$orderby=RequestDate%20desc,Type";
	// resultString = GET_LIS + basefilter + "&inDate=" + inDate + orderBy;
	// return resultString;
	// }

	// /**
	// * 得到患者的检查
	// *
	// * @param patId
	// * 门诊号
	// * @return
	// */
	// public static String getRisByPatId(String patId) {
	// String resultString = "";
	// String basefilter = "patIds=" + patId;
	// String orderBy = "&$orderby=RequestDate desc,ItemCode";
	// resultString = GET_RIS + basefilter + orderBy.replace(" ", "%20");
	// return resultString;
	// }
	//
	// /**
	// * 查看指定时间的检查
	// *
	// * @param patId
	// * 门诊号
	// * @param rquestdate
	// * 请求日期
	// * @return
	// */
	// public static String getRisByPatIdAndRequestDate(String patId,
	// String rquestdate) {
	// String tommorowDate = DateUtils.getTomorrow(rquestdate);
	// String resultString = "";
	// String basefilter = "patIds=" + patId;
	// String orderBy = "$orderby=RequestDate desc,ItemCode";
	//
	// String filter = "$filter=RequestDate ge '" + rquestdate
	// + "'and RequestDate lt '" + tommorowDate + "'";
	// resultString = (GET_RIS + basefilter + "&" + filter + "&" + orderBy)
	// .replace(" ", "%20");
	// return resultString;
	// }

	// /**
	// * 获取一条的检查的结果
	// *
	// * @param patId
	// * 住院号
	// * @param reportId
	// * 报告号
	// * @param reportDate
	// * 请求日期
	// * @return
	// */
	// public static String getRisResult(String patId, String reportId,
	// String reportDate) {
	//
	// return GET_RIS + "patId=" + patId + "&reportId=" + reportId
	// + "&reportDate=" + reportDate;
	//
	// }

	// /***
	// * 获得影像URL
	// *
	// * @param idNum
	// * 检查报告号
	// * @return
	// */
	// public static String getRisUrl(String idNum) {
	// String resultString = "";
	// resultString = GET_RIS + "idNum=" + idNum;
	// return resultString;
	// }

	/**
	 * 根据住院号和时间查询体征数据
	 * 
	 * @param patId
	 *            住院号
	 * @param dateTime
	 *            时间
	 * @return URL api/RestTemperatureChart?patId=176149&date=20130192
	 */
	public static String getSignDataByTime(String patId, String dateTime) {
		String resultString = "";
		resultString = GET_TEMP + "patId=" + patId + "&date=" + dateTime;
		return resultString;
	}

	/**
	 * 根据住院号和时间查询体征数据
	 * 
	 * @param patId
	 *            住院号
	 * @param dateTime
	 *            时间
	 * @return api/RestTemperatureChart?type=kk&patId=176149&date=20130119
	 */
	public static String getSignChartByTime(String patId, String dateTime) {
		String resultString = "";
		resultString = GET_TEMP + "type=kk&patId=" + patId + "&date="
				+ dateTime;
		return resultString;
	}

	/**
	 * 得到操作者所有便签
	 * 
	 * @param creatorId
	 *            创建者ID
	 * @return
	 */
	public static String getAllNotes(String creatorId) {
		String resultString = "";
		String filter = "CreatorId eq '" + creatorId + "'";
		resultString = (NOTES_BASE + "&$filter=" + filter + "&$orderby=CreatedAt desc")
				.replace(" ", "%20");
		return resultString;
	}

	/**
	 * 根据时间 筛选便签
	 * 
	 * @param ChoiceDate
	 *            选择的日期 ----与 CreateAt 比对
	 * @return api/resttodo?$expand&$filter=BeginDate ge '2014-02-19' and
	 *         BeginDate lt '2014-02-20' and CreatorId eq '1097'
	 * 
	 * 
	 */
	public static String getNotesByChoiceDate(String creatorId, String today,
			String tomorrow) {
		String resultString = "";
		String filter = "BeginDate ge '" + today + "'" + " and BeginDate lt '"
				+ tomorrow + "'";
		resultString = (NOTES_BASE + "&$filter=" + filter
				+ " and CreatorId eq '" + creatorId + "'").replace(" ", "%20");
		return resultString;
	}

	/**
	 * 得到病人所有便签
	 * 
	 * @param objectId
	 *            病人ID
	 * @return
	 */
	public static String getPatientAllNotes(String objectId) {
		String resultString = "";
		String filter = "ObjectId eq '" + objectId + "'";
		resultString = (NOTES_BASE + "&$filter=" + filter + "&$orderby=CreatedAt desc")
				.replace(" ", "%20");
		return resultString;
	}

	/**
	 * 上传附件的基本地址(含TodoId)
	 * 
	 * @param title
	 * @param extra
	 * @param todoId
	 * @param objType
	 * @param objId
	 * @param accountId
	 * @return
	 */
	public static String uploadAttach(String title, String extra,
			String todoId, String objType, String objId, String accountId,
			String creatorName, String deleted) {

		String resultString = "";
		String subParams = "file={0}&max={1}";
		String name = URLEncoder.encode(creatorName);
		subParams = "title=" + URLEncoder.encode(title) + "&extra="
				+ URLEncoder.encode(extra) + "&todoId=" + todoId + "&objType="
				+ objType + "&objId=" + objId + "&accountId=" + accountId
				+ "&creatorName=" + name + "&deleted=" + deleted;
		resultString = FILE_BASE + subParams;
		return resultString;
	}

	/**
	 * 得到系统的消息
	 * 
	 * @param userId
	 * @return
	 */
	public static String getCenterMessage(String userId, String division,
			String lastDate, String lastTime) {
		String resultString = "";
		resultString = MESSAGE_CENTER + "userId=" + userId + "&division="
				+ division + "&lastDate=" + lastDate + "&lasttTime=" + lastTime;
		return resultString;
	}

	/**
	 * 系统操作日志的上传接口
	 * 
	 * @return
	 */
	public static String getActionRecord() {
		return ACTION_RECORD;
	}

	// /**
	// * 得到病区的医嘱信息
	// *
	// * @Title: getAdvice
	// * @Description: TODO
	// * @param divisonCode
	// * 病区号码
	// * @param flag
	// * 新开医嘱
	// * @return
	// * @return: String
	// */
	// public static String getAdvice(String divisonCode, int flag) {
	// String resultString = "";
	// resultString = REST_ADVICE + "divisionCode=" + divisonCode + "&flag="
	// + flag;
	// return resultString;
	// }
}
