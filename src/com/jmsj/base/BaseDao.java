package com.jmsj.base;

import org.apache.ibatis.session.SqlSession;

public class BaseDao {
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
