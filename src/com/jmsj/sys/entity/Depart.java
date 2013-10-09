
package com.jmsj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.identity.Group;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;

/**
 * 机构表
 * @author JQ88
 *
 */
@Entity
@Table("tb_depart")
public class Depart implements Group, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//主键id
	@Id
	@Column(name="departId",length=40)
	private String departId;
	//父id
	@Column(name="departPid",length=40)
    private String departPid;
	//机构名称
	@Column(name="departName",length=200)
    private String departName;
	//机构地址
	@Column(name="departAddr",length=250)
    private String departAddr;
	//机构排序
	@Column(name="departSortAll",length=200)
    private String departSortAll;
	//机构状态
	@Column(name="departState",length=2)
    private int departState;
	//机构类型
	@Column(name="departType",length=2)
    private int departType;
	//机构是否被删除
	@Column(name="departIsDel",length=2)
    private int departIsDel;
	//创建时间
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
