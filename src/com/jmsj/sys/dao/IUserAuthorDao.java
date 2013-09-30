package com.jmsj.sys.dao;

import java.util.List;

import com.jmsj.sys.entity.Author;
import com.jmsj.sys.entity.UserAuthor;

public interface IUserAuthorDao {
	
	public boolean add(UserAuthor ua);
	
	public boolean update(UserAuthor ua);
	
	public boolean deleteById(String uaId);
	
	public boolean deleteByUserId(String userId);
	
	public boolean deleteByAuthorId(String authId);
	
	public UserAuthor getUserAuthor(String userId);
	
	public List<Author> findAuthorsByUserId(String userId);
	
	public List<Author> findAuthorsByUserAndRole(String userId);

}
