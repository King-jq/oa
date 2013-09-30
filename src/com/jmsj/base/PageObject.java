package com.jmsj.base;

import java.util.List;

public class PageObject<T> {
	
	private Integer pageNum;//开始页数
	private Integer pageNo;//返回页数
	private Integer total;//总页数
	private List<T> lists;//返回列表
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}

}
