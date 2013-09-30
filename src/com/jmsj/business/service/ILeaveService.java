package com.jmsj.business.service;

import java.util.List;

import com.jmsj.business.entity.Leave;
import com.jmsj.sys.entity.User;

public interface ILeaveService {
	public boolean start(String key, Leave leave, User user);
	public boolean delete(String lid);
	public boolean update(Leave leave);
	public boolean setEnd(String lid);
	public Leave getLeaveById(String lid);
	public List<Leave> findLeaveByUser(Leave leave);

}
