package com.jmsj.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jmsj.sys.entity.User;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse resp, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		String url = req.getRequestURL().toString();
		if(url.indexOf("login") != -1 || url.indexOf("resource") != -1){
			return true;
		}else{
			User user = (User) req.getSession().getAttribute("user");
			if(user == null){
				req.getRequestDispatcher("/user/loginJson").forward(req, resp);
				return false;
			}else{
				return true;
			}
		}
	}

}
