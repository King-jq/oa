package com.jmsj.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IRoleDao;
import com.jmsj.sys.entity.Role;
import com.jmsj.sys.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	
	@Resource(name="roleDao")
	private IRoleDao roleDao;

	@Override
	public boolean add(Role role) {
		return roleDao.add(role);
	}

	@Override
	public boolean update(Role role) {
		return roleDao.update(role);
	}

	@Override
	public boolean delete(String roleId) {
		return roleDao.delete(roleId);
	}

	@Override
	public Role getRole(String roleId) {
		return roleDao.getRole(roleId);
	}

	@Override
	public List<Role> findRoles() {
		return roleDao.findRoles();
	}

}
