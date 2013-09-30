package com.jmsj.sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.sys.dao.IDepartDao;
import com.jmsj.sys.entity.Depart;

@Repository("departDao")
public class DepartDaoImpl implements IDepartDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean add(Depart depart) {
		try {
			sqlSession.insert("addDepart", depart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Depart depart) {
		try {
			sqlSession.update("update", depart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Depart getDepartById(String id) {
		try {
			return sqlSession.selectOne("getDepartById", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			sqlSession.delete("delete", id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String getMaxSortAll(String pid) {
		try {
			return sqlSession.selectOne("getMaxSortAll", pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Depart> findDepartsByPid(String pid) {
		try {
			return sqlSession.selectList("findDepartsByPid", pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Depart getDepartByUser(String userId) {
		try{
			return sqlSession.selectOne("getDepartByUser", userId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Depart getPDepartById(String departId) {
		try{
			return sqlSession.selectOne("getPDepartById", departId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
