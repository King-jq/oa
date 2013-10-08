package com.jmsj.activiti.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.stereotype.Service;

import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.service.IDepartService;
import com.jmsj.sys.service.IUserService;

/**
 * 重写了用户管理接口
 * @author JQ88
 *
 */
@Service("userEntityManager")
public class CustomUserEntityManager extends UserEntityManager {
	
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="departService")
	private IDepartService departService;

	@Override
	public UserEntity findUserById(String userId) {
		return userService.getUser(userId);
	}

	@Override
	public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
		return super.findUserByQueryCriteria(query, page);
	}

	@Override
	public List<Group> findGroupsByUser(String userId) {
		Depart depart = departService.getDepartByUser(userId);
		List<Group> groups = null;
		if(depart != null){
			groups = new ArrayList<Group>(1);
			groups.add(depart);
		}
		return groups;
	}

	@Override
	public UserQuery createNewUserQuery() {
		return super.createNewUserQuery();
	}

	@Override
	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,
			String key) {
		return super.findUserInfoByUserIdAndKey(userId, key);
	}

	@Override
	public List<String> findUserInfoKeysByUserIdAndType(String userId,
			String type) {
		return super.findUserInfoKeysByUserIdAndType(userId, type);
	}

	@Override
	public Boolean checkPassword(String userId, String password) {
		return super.checkPassword(userId, password);
	}

	@Override
	public List<User> findPotentialStarterUsers(String proceDefId) {
		return super.findPotentialStarterUsers(proceDefId);
	}

	@Override
	public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap,
			int firstResult, int maxResults) {
		return super.findUsersByNativeQuery(parameterMap, firstResult, maxResults);
	}

	@Override
	public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
		return super.findUserCountByNativeQuery(parameterMap);
	}

}
