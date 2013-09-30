package com.jmsj.business.dao;

import java.util.List;

import com.jmsj.business.entity.Leave;

public interface ILeaveDao {
	
	public boolean save(Leave leave);
	public boolean delete(String lid);
	public boolean update(Leave leave);
	public boolean setEnd(String lid);
	public Leave getLeaveById(String lid);
	public List<Leave> findLeaveByUser(Leave leave);

}
