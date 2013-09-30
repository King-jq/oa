package com.jmsj.sys.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IRoleAuthorDao;
import com.jmsj.sys.entity.RoleAuthor;

@Repository("roleAuthorDao")
public class RoleAuthorDaoImpl implements IRoleAuthorDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(RoleAuthor ra) {
		try {
			sqlSession.insert("add", ra);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(RoleAuthor ra) {
		try {
			sqlSession.update("update", ra);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteById(String id) {
		try {
			sqlSession.delete("deleteById", id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteByRoleId(String roleId) {
		try {
			sqlSession.delete("deleteByRoleId", roleId);
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
	public RoleAuthor getRoleAuthorById(String id) {
		try {
			return sqlSession.selectOne("getRoleAuthorById", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
