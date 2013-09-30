package com.jmsj.sys.dao;

import java.util.List;

import com.jmsj.sys.entity.Role;

public interface IRoleDao {
	
	public boolean add(Role role);
	public boolean update(Role role);
	public boolean delete(String roleId);
	public Role getRole(String roleId);
	public List<Role> findRoles();

}
