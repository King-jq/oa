package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

//用户角色表
@Entity
@Table("tb_user_role")
public class UserRole {
	
	@Id
	@Column(name="urId",length=40)
	private String urId;
	@Column(name="userId",length=40)
	private String userId;
	@Column(name="roleId",length=40)
	private String roleId;
	
	public String getUrId() {
		return urId;
	}
	public void setUrId(String urId) {
		this.urId = urId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
