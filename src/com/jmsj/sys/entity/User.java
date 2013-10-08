
package com.jmsj.sys.entity;

import java.util.Date;

import org.activiti.engine.impl.persistence.entity.UserEntity;

import com.jmsj.sys.annotation.Column;
import com.jmsj.sys.annotation.Entity;
import com.jmsj.sys.annotation.Id;
import com.jmsj.sys.annotation.Table;
/**
 * 用户信息表
 * @author JQ88
 *
 */
@Entity
@Table("tb_user")
public class User extends UserEntity{

	private static final long serialVersionUID = 1L;
	
	//主键
	@Id
	@Column(name="userId",length=40)
	private String userId;
	//用户名
	@Column(name="userName",length=100)
    private String userName;
	//用户密码
	@Column(name="passwd",length=40)
    private String passwd;
	//真实姓名
	@Column(name="trueName", length=100)
    private String trueName;
	//年龄
	@Column(name="age",length=3)
    private int age;
	//是否已经删除
	@Column(name="isDel",length=2)
    private int isDel;
	//是否是管理员用户
	@Column(name="isSys",length=2)
    private int isSys;
	//创建时间
	@Column(name="createDate",length=6)
    private Date createDate;
	//登陆机构
	private Depart depart;
	
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

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

}
