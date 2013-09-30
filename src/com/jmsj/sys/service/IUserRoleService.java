package com.jmsj.sys.service;

import java.util.List;

import com.jmsj.sys.entity.UserRole;

public interface IUserRoleService {
	
	public boolean add(UserRole ur);
	
	public boolean update(UserRole ur);
	
	public boolean deleteById(String urId);
	
	public boolean deleteByUserId(String userId);
	
	public boolean deleteByRoleId(String roleId);
	
	public UserRole getUserRoleById(String urId);
	
	public UserRole getUserRoleByUserId(String urId);
	
	public List<UserRole> findAllUserRoles();

}
