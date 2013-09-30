package com.jmsj.sys.entity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

//用户权限表
@Entity
@Table("tb_user_author")
public class UserAuthor {
	
	@Id
	@Column(name="uaId",length=40)
	private String uaId;
	@Column(name="userId",length=40)
	private String userId;
	@Column(name="authId",length=40)
	private String authId;
	
	public String getUaId() {
		return uaId;
	}
	public void setUaId(String uaId) {
		this.uaId = uaId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
}
