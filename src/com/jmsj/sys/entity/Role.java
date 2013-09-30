package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;

//角色表
@Entity(name="tb_role")
public class Role {
	//角色id
	@Id(name="roleId",length=40)
	private String roleId;
	//角色名称
	@Column(name="roleName",length=100)
	private String roleName;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
