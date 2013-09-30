package com.jmsj.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IUserRoleDao;
import com.jmsj.sys.entity.UserRole;
import com.jmsj.sys.service.IUserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

	@Resource(name="userRoleDao")
	private IUserRoleDao userRoleDao;

	@Override
	public boolean add(UserRole ur) {
		return userRoleDao.add(ur);
	}

	@Override
	public boolean update(UserRole ur) {
		return userRoleDao.update(ur);
	}

	@Override
	public boolean deleteById(String urId) {
		return userRoleDao.deleteById(urId);
	}

	@Override
	public boolean deleteByUserId(String userId) {
		return userRoleDao.deleteByUserId(userId);
	}

	@Override
	public boolean deleteByRoleId(String roleId) {
		return userRoleDao.deleteByRoleId(roleId);
	}

	@Override
	public UserRole getUserRoleById(String urId) {
		return userRoleDao.getUserRoleById(urId);
	}

	@Override
	public UserRole getUserRoleByUserId(String urId) {
		return userRoleDao.getUserRoleByUserId(urId);
	}

	@Override
	public List<UserRole> findAllUserRoles() {
		return userRoleDao.findAllUserRoles();
	}

}
