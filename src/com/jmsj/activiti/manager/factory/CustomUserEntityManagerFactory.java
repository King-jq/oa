package com.jmsj.activiti.manager.factory;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;

public class CustomUserEntityManagerFactory implements SessionFactory {
	
	 private UserEntityManager userEntityManager;  

	@Override
	public Class<?> getSessionType() {
		return UserEntityManager.class;
	}

	@Override
	public Session openSession() {
		return userEntityManager;
	}

	public UserEntityManager getUserEntityManager() {
		return userEntityManager;
	}

	@Resource(name="userEntityManager")
	public void setUserEntityManager(UserEntityManager userEntityManager) {
		this.userEntityManager = userEntityManager;
	}

}
