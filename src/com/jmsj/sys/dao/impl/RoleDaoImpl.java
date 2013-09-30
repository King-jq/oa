package com.jmsj.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IRoleDao;
import com.jmsj.sys.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao {
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(Role role) {
		try {
			sqlSession.insert("add", role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Role role) {
		try {
			sqlSession.update("update", role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String roleId) {
		try {
			sqlSession.delete("delete", roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Role getRole(String roleId) {
		try {
			return sqlSession.selectOne("getRole", roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Role> findRoles() {
		try {
			return sqlSession.selectList("findRoles");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
