package com.jmsj.sys.service;

import java.util.List;

import com.jmsj.sys.entity.Depart;

public interface IDepartService {
	
	public boolean add(Depart depart);
	
	public boolean update(Depart depart);
	
	public Depart getDepartById(String id);
	
	public boolean delete(String id);
	
	public String getMaxSortAll(String pid);
	
	public List<Depart> findDepartsByPid(String pid);
	
	public Depart getDepartByUser(String userId);
	
	public Depart getPDepartById(String departId);
}
