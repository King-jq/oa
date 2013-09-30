package com.jmsj.sys.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IAuthorDao;
import com.jmsj.sys.entity.Author;

@Repository("authorDao")
public class AuthorDaoImpl implements IAuthorDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(Author author) {
		try{
			sqlSession.insert("add", author);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String authId) {
		try{
			sqlSession.delete("delete", authId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Author author) {
		try{
			sqlSession.update("update", author);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public Author getAuthor(String id) {
		try{
			return sqlSession.selectOne("getAuthor", id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
