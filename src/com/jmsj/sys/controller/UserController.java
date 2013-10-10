package com.jmsj.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.activiti.engine.RepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jmsj.sys.entity.Depart;
import com.jmsj.sys.entity.Json;
import com.jmsj.sys.entity.User;
import com.jmsj.sys.exception.UserException;
import com.jmsj.sys.service.IDepartService;
import com.jmsj.sys.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	@Resource(name="departService")
	private IDepartService departService;
	//列表每页显示的数量
	private Integer pageNum = 10;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String list(Integer pageNo, Model model){
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		pageNo = (pageNo - 1) * pageNum;
		List<User> users = userService.list(pageNo, pageNum);
		model.addAttribute("users", users);
		return "user/listUser";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model, String departId){
		model.addAttribute("user", new User());
		model.addAttribute("departId", departId);
		return "user/addUser";
	}
	
	/**
	 * 如果是上传文件数组 需要参数名添加@RequestParam("参数名"),否则不会自动转换成数组 
	 * @param user
	 * @param br
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Model model, String departId, User user,@RequestParam("file")MultipartFile file){
		
		User u = userService.isHave(user.getUserName());
		
		if(u != null){
			model.addAttribute("departId", departId);
			return "user/addUser";
		}
		
		if(departId==null || "".equals(departId)){
			return "redirect:/depart/list";
		}
		userService.add(user, departId);
		return "redirect:/depart/list";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "user/userLoginJson";
	}
	
	@RequestMapping(value="/loginJson", method=RequestMethod.GET)
	public String loginJson(){
		return "user/userLoginJson";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String userName, String passwd, HttpSession session){
		User user = userService.login(userName, passwd);
		if(user == null) throw new UserException("账号或密码错误!");
		session.setAttribute("user", user);
		List<Depart> departs = departService.getDepartByUser(user.getUserId());
		if(departs != null && departs.size() > 1){
			session.setAttribute("departs", departs);
			return "";
		}
		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpSession session){
		
		return "common/index";
	}
	
	@RequestMapping(value="/loginJson", method=RequestMethod.POST, params="json")
	@ResponseBody
	public Json loginJson(String userName, String passwd, HttpSession session){
		Json json = new Json();
		User user = userService.login(userName, passwd);
		if(user == null){
			json.setState(false);
		}else{
			session.setAttribute("user", user);
			List<Depart> departs = departService.getDepartByUser(user.getUserId());
			if(departs != null && departs.size() > 1){
				session.setAttribute("departs", departs);
				json.setObject(departs);
			}
			json.setState(true);
		}
		return json;
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public String showUser(@PathVariable String userId, Model mode){
		User user = userService.getUser(userId);
		mode.addAttribute("user", user);
		return "user/showUser";
	}
	
	/**
	 * 返回json格式的数据
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, params="json")
	@ResponseBody
	public User showUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return user;
	}
	
	@RequestMapping(value="/delete/{userId}",method=RequestMethod.GET)
	public String deleteUser(@PathVariable String userId){
		userService.delete(userId);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/update/{userId}", method=RequestMethod.GET)
	public String update(@PathVariable String userId, Model model){
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		return "user/updateUser";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(User user, Model model){
		userService.update(user);
		return "redirect:/user/users";
	}
}
