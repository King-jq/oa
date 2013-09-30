package com.jmsj.sys.service;

import com.jmsj.sys.entity.Author;

public interface IAuthorService {
	
	public boolean add(Author author);
	
	public boolean delete(String authId);
	
	public boolean update(Author author);
	
	public Author getAuthor(String id);
	
}
