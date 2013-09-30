package com.jmsj.activiti.manager.factory;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;

public class CustomGroupEntityManagerFactory implements SessionFactory {
	
	private GroupEntityManager groupEntityManager;

	@Override
	public Class<?> getSessionType() {
		return GroupEntityManager.class;
	}

	public GroupEntityManager getGroupEntityManager() {
		return groupEntityManager;
	}

	@Resource(name="groupEntityManager")
	public void setGroupEntityManager(GroupEntityManager groupEntityManager) {
		this.groupEntityManager = groupEntityManager;
	}

	@Override
	public Session openSession() {
		return groupEntityManager;
	}

}
