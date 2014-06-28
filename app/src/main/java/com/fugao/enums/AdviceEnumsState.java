/**   
 * Copyright © 2014 上海复高计算机科技有限公司. All rights reserved.
 * 
 * @Title: AdviceEnumsState.java 
 * @Prject: FugaoBase
 * @Package: com.fugao.enums 
 * @Description: TODO
 * @author: 陈亮    chenliang@fugao.com
 * @date: 2014年5月8日 下午3:13:21 
 * @version: V1.0   
 */
package com.fugao.enums;

/**
 * 医嘱的枚举状态
 * 
 * @ClassName: AdviceEnumsState
 * @Description: TODO
 * @author: 陈亮 chenliang@fugao.com
 * @date: 2014年5月8日 下午3:13:21
 */
public enum AdviceEnumsState {
	ALL(-1, "全部"), New(0, "新建"), UnSubmitted(1, "暂存"), Executing(2, "执行中"), Executed(
			3, "已执行"), Stoped(4, "停止"), Canceled(5, "取消"), Invalid(6, "作废"), UnExecuted(
			8, "未执行"), UnExecuting(9, "已确认"), UnChecked(10, "尚未审核"), Exception(
			11, "异常状态");
	private int key;
	private String value;

	private AdviceEnumsState(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// 普通方法
	public static int getKeyByValue(String value) {
		for (AdviceEnumsState category : AdviceEnumsState.values()) {
			if (category.getValue().equals(value)) {
				return category.getKey();
			}
		}
		return -2;
	}
	


}
