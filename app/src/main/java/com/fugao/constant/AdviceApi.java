package com.fugao.constant;

public class AdviceApi extends PublicApi {

	/**
	 * 停嘱接口
	 */
	public static String STOP_ADVICE = REST_ADVICE + "status=1";
	public static String TEMPSAVE_ADVICE = REST_ADVICE + "type=submit";
	
	/**
	 * 得到病区的医嘱信息
	 * 
	 * @Title: getAdvice
	 * @Description: TODO
	 * @param divisonCode
	 *            病区号码
	 * @param flag
	 *            新开医嘱
	 * @return
	 * @return: String
	 */
	public static String getAdvice(String divisonCode, int flag) {
		String resultString = "";
		resultString = REST_ADVICE + "divisionCode=" + divisonCode + "&flag="
				+ flag;
		return resultString;
	}

	/**
	 * http://192.168.15.16/api/RestAdvice/?patId=000574-01&type=0
	 * &startDate=2010-06-07&endDate=2000-01-01&AdStatus=5
	 * 
	 * @param patId
	 * @param type
	 * @return
	 */
	public static String getAdvicByOptions(String patId, int type,
			String startDate, String endDate, int AdStatus) {
		String resultString = "";
		resultString = REST_ADVICE + "patId=" + patId + "&type=" + type
				+ "&startDate=" + startDate + "&endDate=" + endDate
				+ "&AdStatus=" + AdStatus;
		return resultString;
	}
	
	/**
	 * 得到频次用法
	 * 
	 * @Title: getAdviceDictionary
	 * @Description: TODO
	 * @param type
	 *            0:频次,1:用法,2:药品,3:非药品,4:CM3,5:CM3手术对应,6:化验标本对应
	 * @return
	 * @return: String
	 */
	public static String getAdviceDictionary(int type) {
		String resultString = "";
		resultString = REST_ADVICE + "type=" + type;
		return resultString;
	}

}
