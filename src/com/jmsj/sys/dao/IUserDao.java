package com.jmsj.sys.dao;

import java.util.List;
import java.util.Map;

import com.jmsj.sys.entity.User;
import com.jmsj.sys.entity.UserDepart;


public interface IUserDao {
	
	public boolean add(User user);
	public boolean delete(String userId);
	public boolean deleteAll(String departId);
	public boolean update(User user);
	public boolean addUserDepart(UserDepart ud);
	public boolean deleteByUserId(String id);
	public boolean deleteByDepartId(String id);
	public boolean deleteById(String id);
	public User getUser(String userId);
	public User isHave(String userName);
	public User login(Map<String, Object> map);
	public List<User> findListUsers(Map<String, Object> map);

}
