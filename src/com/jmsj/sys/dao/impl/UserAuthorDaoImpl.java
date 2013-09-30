package com.jmsj.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IUserAuthorDao;
import com.jmsj.sys.entity.Author;
import com.jmsj.sys.entity.UserAuthor;

@Repository("userAuthorDao")
public class UserAuthorDaoImpl implements IUserAuthorDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(UserAuthor ua) {
		try {
			sqlSession.insert("add", ua);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserAuthor ua) {
		try {
			sqlSession.update("update", ua);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteById(String uaId) {
		try {
			sqlSession.delete("deleteById", uaId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByUserId(String userId) {
		try {
			sqlSession.delete("deleteByUserId", userId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByAuthorId(String authId) {
		try {
			sqlSession.delete("deleteByAuthorId", authId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserAuthor getUserAuthor(String userId) {
		try {
			return sqlSession.selectOne("getUserAuthor", userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Author> findAuthorsByUserId(String userId) {
		try {
			return sqlSession.selectList("findAuthorsByUserId", userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Author> findAuthorsByUserAndRole(String userId) {
		try {
			return sqlSession.selectList("findAUthorsByUserAndRole", userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
