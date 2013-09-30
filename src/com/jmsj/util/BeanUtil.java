package com.jmsj.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Service("beanUtil")
public class BeanUtil implements BeanFactoryAware{

	public static BeanFactory beanFactory;
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		BeanUtil.beanFactory = beanFactory;
	}
}
