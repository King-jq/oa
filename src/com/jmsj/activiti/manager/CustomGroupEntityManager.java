package com.jmsj.activiti.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.stereotype.Service;
import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.service.IDepartService;

@Service("groupEntityManager")
public class CustomGroupEntityManager extends GroupEntityManager{
	
	@Resource(name="departService")
	private IDepartService departService; 

	@Override
	public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
		return super.findGroupByQueryCriteria(query, page);
	}

	@Override
	public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
		return super.findGroupCountByNativeQuery(parameterMap);
	}

	@Override
	public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
		return super.findGroupCountByQueryCriteria(query);
	}

	@Override
	public List<Group> findGroupsByNativeQuery(
			Map<String, Object> parameterMap, int firstResult, int maxResults) {
		return super.findGroupsByNativeQuery(parameterMap, firstResult, maxResults);
	}

	@Override
	public List<Group> findGroupsByUser(String userId) {
		List<Group> groups = null;
		Depart depart = departService.getDepartByUser(userId);
		if(depart != null){
			groups = new ArrayList<Group>(1);
			groups.add(depart);
		}
		return groups;
	}
}
