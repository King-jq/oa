package com.jmsj.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IUserDao;
import com.jmsj.sys.entity.User;
import com.jmsj.sys.service.IUserService;
import com.jmsj.util.MD5;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	public boolean add(User user){
		MD5 md5 = new MD5();
		StringBuffer sb = new StringBuffer(md5.getMD5ofStr(md5.getMD5ofStr(user.getPasswd())));
		user.setUserId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
		user.setPasswd(md5.getMD5ofStr(md5.getMD5ofStr(sb.reverse().toString())));
		user.setCreateDate(new Date());
		return userDao.add(user);
	}

	public boolean delete(String id) {
		return userDao.delete(id);
	}

	public List<User> list(int pageNo,int pageNum){
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("pageNo", new Integer(pageNo));
		maps.put("pageNum", new Integer(pageNum));
		return userDao.findListUsers(maps);
	}

	public User login( String userName,String passwd){
		MD5 md5 = new MD5();
		StringBuffer sb = new StringBuffer(md5.getMD5ofStr(passwd));
		String newPasswd = md5.getMD5ofStr(md5.getMD5ofStr(sb.reverse().toString()));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("userName", userName);
		maps.put("passwd", newPasswd);
		User user = userDao.login(maps);
		if(user == null) return user;
		user.setPasswd(passwd);
		return user;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User isHave(String userName) {
		return this.userDao.isHave(userName);
	}

	@Override
	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}
}
