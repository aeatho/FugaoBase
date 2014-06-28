package com.fugao.enums;
/**
 * 医嘱常量枚举
 * @author findchen
 * TODO
 * 2013-7-17下午7:11:52
 */
public enum AdviceCategory {
	LONG(0, "长期"), TEMPLE(1,"临时"), OUT(2, "出院");
	private int key;
	private String value;

	private AdviceCategory(int key, String value) {
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
        for (AdviceCategory category : AdviceCategory.values()) {  
            if (category.getValue().equals(value)) {  
                return category.getKey();  
            }  
        }  
        return -1;  
    }
    
	public static String getValueByKey(int key){
		
		for (AdviceCategory category : AdviceCategory.values()) {
			if (category.getKey()==key) {
				return category.getValue();
			}
		}
		return "无效类别";
	}
}
