package com.jmsj.sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IUserDao;
import com.jmsj.sys.entity.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public boolean add(User user) {
		sqlSession.insert("addUser", user);
		return true;
	}

	@Override
	public boolean delete(String id) {
		sqlSession.delete("deleteUser", id);
		return true;
	}

	@Override
	public User login(Map<String, Object> maps) {
		User user = sqlSession.selectOne("login", maps);
		return user;
	}

	@Override
	public List<User> findListUsers(Map<String, Object> maps) {
		List<User> users = sqlSession.selectList("findListUsers", maps);
		return users;
	}

	@Override
	public User isHave(String userName) {
		return sqlSession.selectOne("isHave", userName);
	}

	@Override
	public User getUser(String userId) {
		return sqlSession.selectOne("getUser", userId);
	}

	@Override
	public boolean update(User user) {
		sqlSession.update("update", user);
		return true;
	}
}
