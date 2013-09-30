package com.jmsj.sys.dao;

import com.jmsj.sys.entity.Author;

public interface IAuthorDao {
	
	public boolean add(Author author);
	
	public boolean delete(String authId);
	
	public boolean update(Author author);
	
	public Author getAuthor(String id);
	
}
