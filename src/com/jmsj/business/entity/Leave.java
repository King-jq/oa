package com.jmsj.business.entity;

import java.util.Date;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

/**
 * 请假实体类
 * @author JQ
 * @since 2013-09-01
 */
@Entity
@Table("tb_leave")
public class Leave {
	
	@Id
	@Column(name="lid",length=40)
	private String lid;//主键
	@Column(name="createDate",length=6)
	private Date createDate;//创建时间
	@Column(name="startDate",length=6)
	private Date startDate;//请假开始时间
	@Column(name="endDate",length=6)
	private Date endDate;//请假销假时间
	@Column(name="userId",length=6)
	private String userId;//请假人id
	@Column(name="cause",length=4000)
	private String cause;//请假原因
	@Column(name="isEnd",length=2)
	private int isEnd;//是否销假流程结束
	@Column(name="proId",length=40)
	private String proId;//流程实例id
	
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
}
