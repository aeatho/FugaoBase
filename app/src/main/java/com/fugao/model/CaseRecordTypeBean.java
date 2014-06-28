package com.fugao.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * �������� ����
 * 
 * @author chenliang
 * @date 2012-12-20
 */
public class CaseRecordTypeBean {
	/**
	 * ���������
	 */
	@JsonProperty
	public String FullName;
	/**
	 * �����������
	 */
	@JsonProperty
	public String TableName;
	/**
	 * ����������
	 */
	@JsonProperty
	public String CodeGroup;
	/**
	 * ������Ŀ
	 */
	@JsonProperty
	public String Count;
	/**
	 * �ĵ�������
	 */
	@JsonProperty
	public String Code;
	/**
	 * �����ĵ����
	 */
	@JsonProperty
	public String Name;
	/**
	 * �������ӽڵ�ı���
	 */
	@JsonProperty
	public String Title;
}
