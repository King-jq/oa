
package com.jmsj.sys.entity;

import java.util.Date;

import org.activiti.engine.impl.persistence.entity.UserEntity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
@Entity(name="tb_user")
public class User extends UserEntity{

	private static final long serialVersionUID = 1L;
	
	@Id(name="userId",length=40)
	private String userId;
	@Column(name="userName",length=100)
    private String userName;
	@Column(name="passwd",length=40)
    private String passwd;
	@Column(name="trueName", length=100)
    private String trueName;
	@Column(name="departId",length=40)
    private String departId;
	@Column(name="age",length=3)
    private int age;
	@Column(name="isDel",length=2)
    private int isDel;
	@Column(name="isSys",length=2)
    private int isSys;
	@Column(name="createDate",length=6)
    private Date createDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String value) {
        this.userId = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String value) {
        this.userName = value;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String value) {
        this.passwd = value;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String value) {
        this.trueName = value;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String value) {
        this.departId = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int value) {
        this.isDel = value;
    }

    public int getIsSys() {
        return isSys;
    }

    public void setIsSys(int value) {
        this.isSys = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date value) {
        this.createDate = value;
    }
    
	@Override
	public String getId() {
		return this.userId;
	}

	@Override
	public void setId(String id) {
		this.userId=id;
	}

	@Override
	public String getFirstName() {
		return this.userName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.userId = firstName;
	}

	@Override
	public String getLastName() {
		return this.userName;
	}

	@Override
	public void setLastName(String lastName) {
		this.userName = lastName;
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public void setEmail(String email) {
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public void setPassword(String password) {
	}

}
