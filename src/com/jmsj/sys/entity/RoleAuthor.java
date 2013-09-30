package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;

//角色权限表
@Entity(name="tb_role_author")
public class RoleAuthor {
	
	@Id(name="raId", length=40)
	private String raId;
	@Column(name="roleId", length=40)
	private String roleId;
	@Column(name="authId", length=40)
	private String authId;
	
	public String getRaId() {
		return raId;
	}
	public void setRaId(String raId) {
		this.raId = raId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}

}
