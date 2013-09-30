package com.jmsj.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IUserAuthorDao;
import com.jmsj.sys.entity.Author;
import com.jmsj.sys.entity.UserAuthor;
import com.jmsj.sys.service.IUserAuthorService;

@Service("userAuthorService")
public class UserAuthorServiceImpl implements IUserAuthorService{
	
	@Resource(name="userAuthorDao")
	private IUserAuthorDao userAuthorDao;

	@Override
	public boolean add(UserAuthor ua) {
		return userAuthorDao.add(ua);
	}

	@Override
	public boolean update(UserAuthor ua) {
		return userAuthorDao.update(ua);
	}

	@Override
	public boolean deleteById(String uaId) {
		return userAuthorDao.deleteById(uaId);
	}

	@Override
	public boolean deleteByUserId(String userId) {
		return userAuthorDao.deleteByUserId(userId);
	}

	@Override
	public boolean deleteByAuthorId(String authId) {
		return userAuthorDao.deleteByAuthorId(authId);
	}

	@Override
	public UserAuthor getUserAuthor(String userId) {
		return userAuthorDao.getUserAuthor(userId);
	}

	@Override
	public List<Author> findAuthorsByUserId(String userId) {
		return userAuthorDao.findAuthorsByUserId(userId);
	}

	@Override
	public List<Author> findAuthorsByUserAndRole(String userId) {
		return userAuthorDao.findAuthorsByUserAndRole(userId);
	}

}
