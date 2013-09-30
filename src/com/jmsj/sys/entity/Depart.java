
package com.jmsj.sys.entity;

import java.util.Date;

import org.activiti.engine.identity.Group;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;

@Entity(name="tb_depart")
public class Depart implements Group{
	
	private static final long serialVersionUID = 1L;
	
	@Id(name="departId",length=40)
	private String departId;
	@Column(name="departPid",length=40)
    private String departPid;
	@Column(name="departName",length=200)
    private String departName;
	@Column(name="departAddr",length=250)
    private String departAddr;
	@Column(name="departSortAll",length=200)
    private String departSortAll;
	@Column(name="departState",length=2)
    private int departState;
	@Column(name="departType",length=2)
    private int departType;
	@Column(name="departIsDel",length=2)
    private int departIsDel;
	@Column(name="createDate",length=6)
    private Date createDate;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String value) {
        this.departId = value;
    }

    public String getDepartPid() {
        return departPid;
    }

    public void setDepartPid(String value) {
        this.departPid = value;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String value) {
        this.departName = value;
    }

    public String getDepartAddr() {
        return departAddr;
    }

    public void setDepartAddr(String value) {
        this.departAddr = value;
    }

    public String getDepartSortAll() {
        return departSortAll;
    }

    public void setDepartSortAll(String value) {
        this.departSortAll = value;
    }

    public int getDepartState() {
        return departState;
    }

    public void setDepartState(int value) {
        this.departState = value;
    }

    public int getDepartType() {
        return departType;
    }

    public void setDepartType(int value) {
        this.departType = value;
    }

    public int getDepartIsDel() {
        return departIsDel;
    }

    public void setDepartIsDel(int value) {
        this.departIsDel = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date value) {
        this.createDate = value;
    }

	@Override
	public String getId() {
		return this.departId;
	}

	@Override
	public void setId(String id) {
		this.departId = id;
	}

	@Override
	public String getName() {
		return this.departName;
	}

	@Override
	public void setName(String name) {
		this.departName = name;
	}

	@Override
	public String getType() {
		return this.departType+"";
	}

	@Override
	public void setType(String type) {
		this.departType = Integer.parseInt(type);
	}

}
