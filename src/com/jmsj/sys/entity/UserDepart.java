package com.jmsj.sys.entity;

/**
 * 人员和机构中间表
 * @author JQ88
 * @since 2013-0-01
 */
public class UserDepart {
	
	//主键
	private String udId;
	//人员id
	private String userId;
	//机构id
	private String departId;
	
	public String getUdId() {
		return udId;
	}
	public void setUdId(String udId) {
		this.udId = udId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}

}
