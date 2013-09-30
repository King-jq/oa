package com.jmsj.business.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import com.jmsj.business.dao.ILeaveDao;
import com.jmsj.business.entity.Leave;
import com.jmsj.business.service.ILeaveService;
import com.jmsj.business.service.IProcessService;
import com.jmsj.sys.entity.User;
import com.jmsj.util.DateUtil;

@Service("leaveService")
public class LeaveServiceImpl implements ILeaveService {
	@Resource(name="leaveDao")
	private ILeaveDao leaveDao;
	@Resource(name="processService")
	private IProcessService processService;

	@Override
	public boolean start(String key, Leave leave, User user) {
		String lid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
		leave.setLid(lid);
		leave.setCreateDate(new Date());
		leave.setUserId(user.getUserId());
		
		int day = DateUtil.dateToDay(leave.getStartDate(), leave.getEndDate());
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("number", new Integer(day));
		values.put("departId", user.getDepartId());
		ProcessInstance pi = processService.startProcessInstanceByKey(key, lid, values, user.getDepartId());
		leave.setProId(pi.getProcessInstanceId());
		if(!leaveDao.save(leave)){
			processService.deleteProcessInstanceById(pi.getProcessInstanceId());
		}
		return true;
	}

	@Override
	public boolean delete(String lid) {
		return leaveDao.delete(lid);
	}

	@Override
	public boolean update(Leave leave) {
		return leaveDao.update(leave);
	}

	@Override
	public boolean setEnd(String lid) {
		return leaveDao.setEnd(lid);
	}

	@Override
	public Leave getLeaveById(String lid) {
		return leaveDao.getLeaveById(lid);
	}

	@Override
	public List<Leave> findLeaveByUser(Leave leave) {
		return leaveDao.findLeaveByUser(leave);
	}

}
