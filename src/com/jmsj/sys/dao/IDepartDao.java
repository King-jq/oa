package com.jmsj.sys.dao;

import java.util.List;

import com.jmsj.sys.entity.Depart;

/**
 * 机构dao接口
 * @author JQ88
 * @since 2013-09-03
 */
public interface IDepartDao {
	
	/**
	 * 新增机构
	 * @param depart
	 * @return
	 */
	public boolean add(Depart depart);
	
	/**
	 * 修改机构
	 * @param depart
	 * @return
	 */
	public boolean update(Depart depart);
	
	public Depart getDepartById(String id);
	
	public boolean delete(String id);
	
	public String getMaxSortAll(String pid);
	
	public List<Depart> findDepartsByPid(String pid);

	public Depart getDepartByUser(String userId);
	
	public Depart getPDepartById(String departId);
}
