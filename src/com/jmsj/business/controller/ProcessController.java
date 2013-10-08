package com.jmsj.business.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jmsj.base.BaseUtil;
import com.jmsj.base.PageObject;
import com.jmsj.business.service.IProcessService;
import com.jmsj.sys.entity.User;

@Controller
@RequestMapping("/process")
public class ProcessController {
	
	@Resource(name="processService")
	private IProcessService processService;
	
	/**
	 * 跳转部署页面
	 * @return
	 */
	@RequestMapping(value="/deploy", method=RequestMethod.GET)
	public String deployProcessByZIP(){
		return "process/deploy";
	}
	
	/**
	 * 部署流程定义
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deploy", method=RequestMethod.POST)
	public String deployProcessByZIP(@RequestParam("file")MultipartFile file, Model model){
		if(!file.isEmpty()){
			try{
				processService.deployProByUploadFile(file.getInputStream());
			}catch(Exception e){
				e.printStackTrace();
				model.addAttribute("result", "部署流程定义失败!");
			}
		}else{
			model.addAttribute("result", "部署文件不能为空!");
		}
		return "process/deploy";
	}
	
	/**
	 * 流程定义列表
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String findAllProcessDef(Integer pageNum, Model model){
		if(pageNum == null){
			pageNum = BaseUtil.PAGE_NUM;
		}
		PageObject<ProcessDefinition> objs = processService.findAllProcessDe(pageNum, BaseUtil.PAGE_NO);
		model.addAttribute("pros", objs);
		return "process/listProcess";
	}
	
	/**
	 * 获取登录用户的任务
	 * @param session
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value="/myTasks", method=RequestMethod.GET)
	public String findAllTasksByUser(HttpSession session, Model model, Integer pageNum){
		if(pageNum == null){
			pageNum = BaseUtil.PAGE_NUM;
		}
		User user = (User) session.getAttribute("user");
		PageObject<Task> tasks = processService.findTasksByUser(user.getDepart().getDepartId(), pageNum, BaseUtil.PAGE_NO);
		model.addAttribute("tasks", tasks);
		return "process/taskProcess";
	}
	
	/**
	 * 签收任务
	 * @param pageNum
	 * @param taskId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="signTask", method=RequestMethod.GET)
	public String signTask(Integer pageNum, String taskId, HttpSession session){
		if(pageNum == null){
			pageNum = BaseUtil.PAGE_NUM;
		}
		User user = (User) session.getAttribute("user");
		processService.signTask(taskId, user);
		return "redirect:/process/myTasks?pageNum="+pageNum;
	}

	/**
	 * 推进任务
	 * @param session
	 * @param taskId
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value="/completeTask", method=RequestMethod.GET)
	public String completeTask(HttpSession session, String taskId, Integer pageNum){
		if(pageNum == null){
			pageNum = BaseUtil.PAGE_NUM;
		}
		User user = (User) session.getAttribute("user");
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("userId", user.getUserId());
		values.put("doUserId", user.getUserId());
		values.put("doInfo", "批准请假!");
		processService.completeTask(taskId, values);
		return "redirect:/process/myTasks?pageNum="+pageNum;
	}
	
	/**
	 * 挂起流程定义
	 * @return
	 */
	@RequestMapping(value="/handPDF", method=RequestMethod.GET)
	public String handPDF(String pdId, HttpSession session){
		User user = (User) session.getAttribute("user");
		processService.handProcessDefinition(pdId, user);
		return "redirect:/prcoess/list";
	}
	
	/**
	 * 激活流程定义
	 * @param pdId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/activitiPDF", method=RequestMethod.GET)
	public String activitiPDF(String pdId, HttpSession session){
		User user = (User) session.getAttribute("user");
		processService.activitiProcessDefinition(pdId, user);
		return "redirect:/prcoess/list";
	}
	
	/**
	 * 挂起流程实例
	 * @return
	 */
	@RequestMapping(value="/handPIS", method=RequestMethod.GET)
	public String handPIS(String piId, Integer pageNum, HttpSession session){
		User user = (User) session.getAttribute("user");
		processService.handProcessInstance(piId, user);
		return "redirect:/process/myTasks?pageNum="+pageNum;
	}
	
	/**
	 * 激活流程实例
	 * @param pdId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/activitiPIS", method=RequestMethod.GET)
	public String activitiPIS(String piId, Integer pageNum, HttpSession session){
		User user = (User) session.getAttribute("user");
		processService.activitiProcessInstance(piId, user);
		return "redirect:/process/myTasks?pageNum="+pageNum;
	}
	
}
