package com.jmsj.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IDepartDao;
import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.service.IDepartService;

@Service("departService")
public class DepartServiceImpl implements IDepartService {
	
	@Resource(name="departDao")
	private IDepartDao departDao;
	
	@Override
	public boolean add(Depart depart) {
		String sortAll = departDao.getMaxSortAll(depart.getDepartPid());
		if(sortAll == null){
			Depart d = departDao.getDepartById(depart.getDepartPid());
			sortAll = d.getDepartSortAll() +"001";
		}else{
			String parent = sortAll.substring(0, sortAll.length() - 3);
			String maxStr = sortAll.substring(sortAll.length() - 3, sortAll.length());
			int max = Integer.parseInt(maxStr) + 1;
			if(max < 10 ){
				maxStr = "00" + max;
			}else if(max < 100){
				maxStr = "0" + max;
			}
			
			sortAll = parent + maxStr;
		}
		depart.setDepartSortAll(sortAll);
		String id = UUID.randomUUID().toString().toUpperCase().replace("-", "");
		depart.setDepartId(id);
		depart.setCreateDate(new Date());
		return departDao.add(depart);
	}

	@Override
	public boolean update(Depart depart) {
		return departDao.update(depart);
	}

	@Override
	public Depart getDepartById(String id) {
		return departDao.getDepartById(id);
	}

	@Override
	public boolean delete(String id) {
		return departDao.delete(id);
	}

	@Override
	public String getMaxSortAll(String pid) {
		return departDao.getMaxSortAll(pid);
	}

	@Override
	public List<Depart> findDepartsByPid(String pid) {
		return departDao.findDepartsByPid(pid);
	}

	@Override
	public List<Depart> getDepartByUser(String userId) {
		return departDao.getDepartByUser(userId);
	}

	@Override
	public Depart getPDepartById(String departId) {
		return departDao.getPDepartById(departId);
	}

}
