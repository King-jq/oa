package com.jmsj.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IRoleAuthorDao;
import com.jmsj.sys.entity.RoleAuthor;
import com.jmsj.sys.service.IRoleAuthorService;

@Service("roleAuthorService")
public class RoleAuthorServiceImpl implements IRoleAuthorService {
	
	@Resource(name="roleAuthorDao")
	private IRoleAuthorDao roleAuthorDao;

	@Override
	public boolean add(RoleAuthor ra) {
		return roleAuthorDao.add(ra);
	}

	@Override
	public boolean update(RoleAuthor ra) {
		return roleAuthorDao.update(ra);
	}

	@Override
	public boolean deleteById(String id) {
		return roleAuthorDao.deleteById(id);
	}

	@Override
	public boolean deleteByRoleId(String roleId) {
		return roleAuthorDao.deleteByRoleId(roleId);
	}

	@Override
	public boolean deleteByAuthorId(String authId) {
		return roleAuthorDao.deleteByAuthorId(authId);
	}

	@Override
	public RoleAuthor getRoleAuthorById(String id) {
		return roleAuthorDao.getRoleAuthorById(id);
	}

}
