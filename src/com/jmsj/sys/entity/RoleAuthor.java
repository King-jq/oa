package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

//角色权限表
@Entity
@Table("tb_role_author")
public class RoleAuthor {
	
	//主键id
	@Id
	@Column(name="raId", length=40)
	private String raId;
	//角色id
	@Column(name="roleId", length=40)
	private String roleId;
	//权限id
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
