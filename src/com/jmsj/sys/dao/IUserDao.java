package com.jmsj.sys.dao;

import java.util.List;
import java.util.Map;

import com.jmsj.sys.entity.User;


public interface IUserDao {
	
	public boolean add(User user);
	public boolean delete(String id);
	public boolean update(User user);
	public User getUser(String userId);
	public User isHave(String userName);
	public User login(Map<String, Object> map);
	public List<User> findListUsers(Map<String, Object> map);

}
