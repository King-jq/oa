package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

//权限表
@Entity()
@Table("tb_author")
public class Author {
	//权限id
	@Id
	@Column(name="authId", length=40)
	private String authId;
	//权限名称或者模块名称
	@Column(name="authName", length=200)
	private String authName;
	//权限方法名称
	@Column(name="methodName", length=200)
	private String methodName;
	//权限class名称
	@Column(name="className", length=200)
	private String className;
	//权限排序
	@Column(name="authAll", length=200)
	private String authAll;
	
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAuthAll() {
		return authAll;
	}
	public void setAuthAll(String authAll) {
		this.authAll = authAll;
	}

}
