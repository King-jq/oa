package com.jmsj.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.entity.User;
import com.jmsj.sys.service.IDepartService;

@Controller
@RequestMapping("/depart")
public class DepartController {
	
	@Resource(name="departService")
	private IDepartService departService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model, String pid){
		model.addAttribute("departPid", pid);
		return "depart/addDepart";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Depart depart){
		if(depart == null){
			return "redirect:/depart/list";
		}
		if(depart.getDepartPid() == null){
			return "redirect:/depart/list";
		}
		departService.add(depart);
		return "redirect:/depart/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listDeparts(Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		Depart depart = departService.getDepartById(user.getDepartId());
		StringBuffer tree = new StringBuffer();
		tree.append("[{");
		if(depart != null){
			tree.append("\"id\":\"").append(depart.getDepartId()).append("\",");
			tree.append("\"text\":\"").append(depart.getDepartName()).append("\",");
			tree.append("\"closed\":\"").append(false).append("\"");
			tree.append("}]");
		}
		model.addAttribute("depart", depart);
		model.addAttribute("json", tree.toString());
		return "depart/listDeparts";
	}
	
	@RequestMapping(value="/listJson", method=RequestMethod.GET, params="json")
	@ResponseBody
	public String findDeparts(String pid, Model model, HttpSession session){
		StringBuffer tree = new StringBuffer();
		if(pid == null){
			User user = (User) session.getAttribute("user");
			Depart depart = departService.getDepartById(user.getDepartId());
			tree.append("[{");
			if(depart != null){
				tree.append("\"id\":\"").append(depart.getDepartId()).append("\",");
				tree.append("\"text\":\"").append(depart.getDepartName()).append("\",");
				tree.append("\"closed\":\"").append(false).append("\"");
				tree.append("}]");
				return tree.toString();
			}
		}else{
			List<Depart> departs = departService.findDepartsByPid(pid);
			if(departs != null && departs.size() > 0){
				tree.append("[");
				for(Depart d : departs){
					tree.append("{");
					tree.append("\"id\":\"").append(d.getDepartId()).append("\",");
					tree.append("\"text\":\"").append(d.getDepartName()).append("\",");
					tree.append("\"closed\":\"").append(false).append("\"");
					tree.append("},");
				}
				return (tree.substring(0, tree.length() - 1) + "]");
			}
		}
		return "";
	}
}
