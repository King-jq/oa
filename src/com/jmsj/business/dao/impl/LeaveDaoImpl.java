package com.jmsj.business.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jmsj.business.dao.ILeaveDao;
import com.jmsj.business.entity.Leave;

@Repository("leaveDao")
public class LeaveDaoImpl implements ILeaveDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public boolean save(Leave leave) {
		try {
			sqlSession.insert("save", leave);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String lid) {
		try {
			sqlSession.delete("delete", lid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Leave leave) {
		try {
			sqlSession.update("update", leave);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean setEnd(String lid) {
		try {
			sqlSession.update("setEnd", lid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Leave getLeaveById(String lid) {
		return sqlSession.selectOne("getLeaveById", lid);
	}

	@Override
	public List<Leave> findLeaveByUser(Leave leave) {
		return sqlSession.selectList("findLeaveByUser", leave);
	}

}
