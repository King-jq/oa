package com.jmsj.business.service;

import java.io.InputStream;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.jmsj.base.PageObject;
import com.jmsj.sys.entity.User;

public interface IProcessService {
	
	/**
	 * 通过上传zip部署文件包部署流程
	 * @param is 文件流
	 * @throws Exception
	 */
	public void deployProByUploadFile(InputStream is) throws Exception;
	
	/**
	 * 获取所有已经部署的最新的流程定义
	 * @return
	 */
	public PageObject<ProcessDefinition> findAllProcessDe(Integer pageNu, Integer pageNo);
	
	/**
	 * 通过流程key删除流程
	 * @param proKey 流程key
	 */
	public void deleteProByKey(String proKey);
	
	/**
	 * 级联删除流程定义和流程实例
	 * @param proKey
	 */
	public void deleteAllByKey(String proKey);
	
	/**
	 * 通过已部署流程定义key启动一个流程实例
	 * @param proKey
	 * @return
	 */
	public ProcessInstance startProcessInstanceByKey(String proKey, String key, Map<String, Object> values, String groupId);
	
	/**
	 * 通过流程实例id删除流程实例
	 * @param id
	 */
	public void deleteProcessInstanceById(String id);
	
	
	/**
	 * 通过用户id获取所有的待办业务
	 * @param userId
	 * @return
	 */
	public PageObject<Task> findTasksByUser(String departId, Integer pageNum, Integer pageNo);
	
	/**
	 * 通过task的id推进流程
	 * @param taskId 任务id
	 * @param values 变量
	 */
	public void completeTask(String taskId, Map<String, Object> values);
	
	/**
	 * 签收任务
	 * @param taskId
	 * @param departId
	 */
	public void signTask(String taskId, User user);
	
	/**
	 * 挂起流程定义
	 * @param processId
	 */
	public void handProcessDefinition(String pdId, User user);
	
	/**
	 * 激活流程定义
	 * @param pdId
	 */
	public void activitiProcessDefinition(String pdId, User user);
	
	/**
	 * 挂起流程实例
	 * @param piId
	 */
	public void handProcessInstance(String piId, User user);
	
	/**
	 * 激活流程实例
	 * @param piId
	 */
	public void activitiProcessInstance(String piId, User user);
	
	/**
	 * 通过流程定义的key，获取流程定于图片资源
	 * @param key
	 * @return
	 */
	public InputStream getProcessDefinitionImageByKey(String key);
	
	/**
	 * 通过流程定义的id，获取流程定于图片资源
	 * @param key
	 * @return
	 */
	public InputStream getProcessDefinitionImageById(String id);
}
