package com.jmsj.sys.entity;

/**
 * json返回值
 * @author JQ88
 *
 */
public class Json {
	private boolean state;
	private Object object;
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

}
