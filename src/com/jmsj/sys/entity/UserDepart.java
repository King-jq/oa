package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

/**
 * 人员和机构中间表
 * @author JQ88
 * @since 2013-0-01
 */
@Entity
@Table("tb_user_deaprt")
public class UserDepart {
	
	//主键
	@Id
	@Column(name="udId",length=40)
	private String udId;
	//人员id
	@Column(name="userId",length=40)
	private String userId;
	//机构id
	@Column(name="departId",length=40)
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
