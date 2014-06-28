package com.fugao.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fugao.model.AccountBean;
import com.fugao.model.AdviceBean;
import com.fugao.model.AppInfoBean;
import com.fugao.model.CaseRecordGroupBean;
import com.fugao.model.CaseRecordTypeBean;
import com.fugao.model.CheckApplyBean;
import com.fugao.model.CheckResultBean;
import com.fugao.model.DepartmentBean;
import com.fugao.model.InspectApplyBean;
import com.fugao.model.InspectResultBean;
import com.fugao.model.NotesBean;
import com.fugao.model.PatAffixBean;
import com.fugao.model.PatientBean;

/**
 * 字符串转模型或者模型集合 string2NotesBeans
 * 
 * @author findchen TODO 2013-6-7下午6:51:49
 */
public class String2Model {
	public static String ITEMS = "Items";
	public static String COUNTS = "Count";
	public static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);

		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	/**
	 * 得到患者的集合
	 * 
	 * @param string
	 *            服务器端返回的患者数据的集合
	 * @return 患者集合
	 */
	public static ArrayList<PatientBean> string2PatientBeans(String string) {
		ArrayList<PatientBean> patientBeans = new ArrayList<PatientBean>();
		String content = getContents(string);

		try {
			patientBeans = objectMapper.readValue(content,
					new TypeReference<List<PatientBean>>() {
					});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return patientBeans;

	}

	public static PatAffixBean string2PatAffixBeans(String string) {
		PatAffixBean affixBean = null;
		try {
			affixBean = objectMapper.readValue(string, PatAffixBean.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affixBean;
	}

	public static PatientBean string2PatientBean(String string) {
		PatientBean patientBean = new PatientBean();

		try {
			patientBean = objectMapper.readValue(string, PatientBean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientBean;
	}

	/**
	 * 转换登陆者的信息内容
	 * 
	 * @param string
	 * @return
	 */
	public static AccountBean string2AccountBean(String string) {
		AccountBean accountBean = new AccountBean();

		try {
			accountBean = objectMapper.readValue(string, AccountBean.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountBean;
	}

	/**
	 * 得到服务器端返回数据的结合的字符串的值
	 * 
	 * @param string
	 *            服务器端的数据
	 * @return 服务器端返回的模型的字符串值
	 */
	public static String getContents(String string) {
		String resultString = "";
		JSONObject jsonObject = null;
		JSONArray jsonArray;
		try {
			jsonObject = new JSONObject(string);
			jsonArray = jsonObject.getJSONArray(ITEMS);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonArray = new JSONArray();
		}
		resultString = jsonArray.toString();
		return resultString;
	}

	/**
	 * 得到服务器端返回结果集的总页数
	 * 
	 * @param string
	 *            服务器端返回的数据
	 * @return 总页数
	 */
	public static int getTotalPages(String string) {
		JSONObject jsonObject = null;
		int count = 0;
		String countString = "";
		try {
			jsonObject = new JSONObject(string);
			countString = jsonObject.getString(COUNTS);
		} catch (JSONException e) {
			e.printStackTrace();
			countString = "0";
		}
		count = Integer.parseInt(countString);
		return count;
	}

	/**
	 * 得到病区信息
	 * 
	 * @param string
	 * @return
	 */
	public static ArrayList<DepartmentBean> string2DepartmentBean(String string) {
		ArrayList<DepartmentBean> departmentBeans = new ArrayList<DepartmentBean>();
		String content = getContents(string);

		try {
			departmentBeans = objectMapper.readValue(content,
					new TypeReference<List<DepartmentBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return departmentBeans;
	}

	public static ArrayList<AppInfoBean> string2UpdateApkBean(String string) {
		ArrayList<AppInfoBean> apkBeans = new ArrayList<AppInfoBean>();
		String content = getContents(string);
		try {
			apkBeans = objectMapper.readValue(content,
					new TypeReference<List<AppInfoBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apkBeans;
	}

	/**
	 * 得到病人检验报告信息
	 * 
	 * @param string
	 *            服务器返回检验数据
	 * @return 检验数据集合
	 */
	public static ArrayList<InspectApplyBean> string2ApplyBean(String string) {
		ArrayList<InspectApplyBean> applyBeans = new ArrayList<InspectApplyBean>();
		String content = getContents(string);
		try {
			applyBeans = objectMapper.readValue(content,
					new TypeReference<List<InspectApplyBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return applyBeans;
	}

	/**
	 * 得到病人的检验结果
	 * 
	 * @param string
	 *            服务器返回检验结果数据
	 * @return 检验结果数据集合
	 */
	public static ArrayList<InspectResultBean> string2InspectResult(
			String string) {
		ArrayList<InspectResultBean> resultBeans = new ArrayList<InspectResultBean>();
		try {
			resultBeans = objectMapper.readValue(string,
					new TypeReference<List<InspectResultBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultBeans;
	}

	/**
	 * 得到检查报告
	 * 
	 * @param string
	 * @return
	 */
	public static ArrayList<CheckApplyBean> string2RisApplyBean(String string) {
		ArrayList<CheckApplyBean> applyBeans = new ArrayList<CheckApplyBean>();
		String content = getContents(string);
		try {
			applyBeans = objectMapper.readValue(content,
					new TypeReference<List<CheckApplyBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyBeans;
	}

	/**
	 * 得到检查结果
	 * 
	 * @param string
	 * @return
	 */
	public static ArrayList<CheckResultBean> string2RisResultBean(String string) {
		ArrayList<CheckResultBean> resultBeans = new ArrayList<CheckResultBean>();
		try {
			resultBeans = objectMapper.readValue(string,
					new TypeReference<List<CheckResultBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultBeans;
	}

	/**
	 * 医嘱数据的集合
	 * 
	 * @param string
	 *            服务器端返回的医嘱数据的集合
	 * @return 医嘱数据的集合
	 */
	public static ArrayList<AdviceBean> string2AdviceBean(String content) {
		ArrayList<AdviceBean> adviceBeans = new ArrayList<AdviceBean>();
		

		try {
			adviceBeans = objectMapper.readValue(content,
					new TypeReference<List<AdviceBean>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adviceBeans;
	}

	/**
	 * 将数据转换为病历组合子节点的组合方式
	 * 
	 * @param string
	 * @return
	 */
	public static ArrayList<CaseRecordGroupBean> string2CaseRecordGroupBean(
			String string) {
		JSONObject jsonObject;
		ArrayList<CaseRecordGroupBean> groupBeans = new ArrayList<CaseRecordGroupBean>();
		try {
			jsonObject = new JSONObject(string);
			JSONArray keys = jsonObject.names();

			List<String> list = objectMapper.readValue(jsonObject.names()
					.toString(), new TypeReference<List<String>>() {
			});
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String lhs, String rhs) {

					return lhs.substring(lhs.length() - 1).compareTo(
							rhs.substring(rhs.length() - 1));
				}
			});

			for (String groupCodeTitle : list) {
				CaseRecordGroupBean caseRecordGroupBean = new CaseRecordGroupBean();
				String[] groupTitleArrayr = groupCodeTitle.split("_");
				if (groupTitleArrayr.length == 2) {
					caseRecordGroupBean.groupTilte = groupTitleArrayr[0];
					caseRecordGroupBean.groupCategoryCode = groupTitleArrayr[1];
				}

				ArrayList<CaseRecordTypeBean> caseRecordTypeBeans = objectMapper
						.readValue(jsonObject.getString(groupCodeTitle),
								new TypeReference<List<CaseRecordTypeBean>>() {
								});
				caseRecordGroupBean.typeBeans = caseRecordTypeBeans;

				groupBeans.add(caseRecordGroupBean);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groupBeans;
	}	
}
