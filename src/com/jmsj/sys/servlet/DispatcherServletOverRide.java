package com.jmsj.sys.servlet;


import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.jmsj.db.DBInit;


public class DispatcherServletOverRide extends DispatcherServlet{
	@Override
	protected void initStrategies(ApplicationContext context) {
		super.initStrategies(context);
		DBInit.init(context);
	}

	
	private static final long serialVersionUID = 1L;

}
