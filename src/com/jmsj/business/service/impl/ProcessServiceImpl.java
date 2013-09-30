package com.jmsj.business.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import com.jmsj.base.PageObject;
import com.jmsj.business.service.IProcessService;
import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.entity.User;
import com.jmsj.sys.service.IDepartService;

@Service("processService")
public class ProcessServiceImpl implements IProcessService{
	
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	@Resource(name="runtimeService")
	private RuntimeService runtimeService;
	@Resource(name="taskService")
	private TaskService taskService;
	@Resource(name="departService")
	private IDepartService departService;
	
	@Override
	public void deployProByUploadFile(InputStream is)
			throws Exception {
		repositoryService.createDeployment().addZipInputStream(new ZipInputStream(is)).deploy();
	}

	@Override
	public void deleteProByKey(String proKey) {
		repositoryService.deleteDeployment(proKey);
	}

	@Override
	public ProcessInstance startProcessInstanceByKey(String proKey, String key, Map<String, Object> values, String groupId) {
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(proKey, key, values);
		TaskQuery query = taskService.createTaskQuery().processInstanceId(pi.getId()).orderByTaskName().asc();
		List<Task> tasks = query.list();
		taskService.claim(tasks.get(0).getId(), values.get("departId").toString());
		Map<String, Object> objs = new HashMap<String, Object>();
		Depart d = departService.getPDepartById(groupId);
		if(d != null){
			objs.put("departId", d.getDepartId());
			taskService.complete(tasks.get(0).getId(), objs);
		}
		return pi;
	}

	@Override
	public void deleteAllByKey(String proKey) {
		repositoryService.deleteDeployment(proKey, true);
	}

	public PageObject<ProcessDefinition> findAllProcessDe(Integer pageNu,
			Integer pageNo) {
		PageObject<ProcessDefinition> page = new PageObject<ProcessDefinition>();
		page.setPageNum(pageNu);
		page.setPageNo(pageNo);
		int total = (int) repositoryService.createProcessDefinitionQuery().latestVersion().count();
		page.setTotal(total);
		List<ProcessDefinition> pros = repositoryService.createProcessDefinitionQuery().latestVersion().listPage(pageNu - 1, pageNo);
		page.setLists(pros);;
		return page;
	}

	@Override
	public void deleteProcessInstanceById(String id) {
		runtimeService.deleteProcessInstance(id, "");
	}

	@Override
	public PageObject<Task> findTasksByUser(String departId, Integer pageNum,
			Integer pageNo) {
		PageObject<Task> tasks = new PageObject<Task>();
		TaskQuery query = taskService.createTaskQuery();
		List<Task> ts = query.taskCandidateGroup(departId).listPage(pageNum - 1, pageNo);
		tasks.setLists(ts);
		long total = query.taskCandidateGroup(departId).count();
		tasks.setPageNum(pageNum);
		tasks.setPageNo(pageNo);
		tasks.setTotal((int) total);
		return tasks;
	}

	@Override
	public void completeTask(String taskId, Map<String, Object> values) {
		taskService.complete(taskId, values);
	}

	@Override
	public void signTask(String taskId, User user) {
		taskService.claim(taskId, user.getDepartId());
	}

	@Override
	public void handProcessDefinition(String pdId, User user) {
		repositoryService.suspendProcessDefinitionById(pdId);
	}

	@Override
	public void activitiProcessDefinition(String pdId, User user) {
		repositoryService.activateProcessDefinitionById(pdId);
	}

	@Override
	public void handProcessInstance(String piId, User user) {
		runtimeService.suspendProcessInstanceById(piId);
	}

	@Override
	public void activitiProcessInstance(String piId, User user) {
		runtimeService.activateProcessInstanceById(piId);
	}

}
