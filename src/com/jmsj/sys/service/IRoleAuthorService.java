package com.jmsj.sys.service;

import com.jmsj.sys.entity.RoleAuthor;

public interface IRoleAuthorService {
	
	public boolean add(RoleAuthor ra);
	
	public boolean update(RoleAuthor ra);
	
	public boolean deleteById(String id);
	
	public boolean deleteByRoleId(String roleId);
	
	public boolean deleteByAuthorId(String authId);
	
	public RoleAuthor getRoleAuthorById(String id);
	
}
