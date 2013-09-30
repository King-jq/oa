package com.jmsj.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jmsj.business.entity.Leave;
import com.jmsj.business.service.ILeaveService;
import com.jmsj.sys.entity.User;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	
	@Resource(name="leaveService")
	private ILeaveService leaveService;
	
	/**
	 * 跳转到填写请假单页面
	 * @param key 流程定义key
	 * @param model
	 * @return
	 */
	@RequestMapping(value="startLeave", method=RequestMethod.GET)
	public String addLeave(String key, Model model){
		if(key == null){
			return "redirect:/process/list";
		}
		model.addAttribute("key", key);
		return "process/leaveProcess";
	}
	
	/**
	 * 提交请假单,并开始请假流程
	 * @param leave
	 * @param key
	 * @param session
	 * @return
	 */
	@RequestMapping(value="startLeave", method=RequestMethod.POST)
	public String addLeave(Leave leave, String key, HttpSession session){
		User user = (User) session.getAttribute("user");
		leaveService.start(key, leave, user);
		return "redirect:/process/list";
	}
}
