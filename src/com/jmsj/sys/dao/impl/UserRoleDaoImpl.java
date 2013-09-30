package com.jmsj.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IUserRoleDao;
import com.jmsj.sys.entity.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements IUserRoleDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(UserRole ur) {
		try {
			sqlSession.insert("add", ur);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserRole ur) {
		try {
			sqlSession.update("update", ur);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteById(String urId) {
		try {
			sqlSession.delete("deleteById", urId);
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
	public UserRole getUserRoleById(String urId) {
		try {
			return sqlSession.selectOne("getUserRoleById", urId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserRole getUserRoleByUserId(String urId) {
		try {
			return sqlSession.selectOne("getUserRoleByUserId", urId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<UserRole> findAllUserRoles() {
		try {
			return sqlSession.selectList("findAllUserRoles");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
